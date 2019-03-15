package com.codedx.bambooplugin;

import com.codedx.client.ApiClient;
import com.codedx.client.ApiException;
import com.codedx.client.api.Projects;
import com.codedx.client.api.ProjectsApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.SSLHandshakeException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ProcessingException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class ProjectRefresherServlet extends HttpServlet {

    private static class CodeDxCredentials {

        private String url;
        private String apiKey;
        private String fingerprint;

        public void setUrl(String url) {
            if(url.endsWith("/")) {
                url = url.substring(0, url.length() - 1);
            }
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setFingerprint(String fingerprint) {
            this.fingerprint = fingerprint;
        }

        public String getFingerprint() {
            return fingerprint;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final ObjectMapper mapper = new ObjectMapper();
        CodeDxCredentials credentials = mapper.readValue(req.getInputStream(), CodeDxCredentials.class);

        // Make sure the URL is valid
        if (!ServerConfigManager.isURLValid(credentials.getUrl())) {
            resp.setStatus(404);
            resp.getOutputStream().print("Malformed Code Dx URL");
            return;
        }

        ApiClient apiClient = ServerConfigManager.getConfiguredClient(credentials.getUrl(), credentials.getApiKey(), credentials.getFingerprint());

        ProjectsApi projectsApi = new ProjectsApi();
        projectsApi.setApiClient(apiClient);

        Projects projects = null;

        try {
            projects = projectsApi.getProjects();
        } catch (ApiException e) {
            // Bad API Token?
            int responseCode = e.getCode();
            String message;
            switch (responseCode) {
                case 403:
                    message = "API token does not have permission to access Code Dx projects";
                    break;
                case 404:
                    message = "Unable to retrieve project list. Please confirm the URL is correct.";
                    break;
                default:
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        message = getBetterErrorMessage(cause);
                    } else {
                        message = e.getMessage();
                    }
                    break;
            }
            responseCode = responseCode == 0 ? 500 : responseCode;
            resp.setStatus(responseCode);
            resp.getOutputStream().print(message);
            return;
        } catch (ProcessingException e) {
            resp.setStatus(404);
            resp.getOutputStream().print("Connection refused. Please confirm that the URL is correct and that the Code Dx server is running.");
            return;
        }

        String projectsJson = mapper.writeValueAsString(projects);
        resp.getOutputStream().print(projectsJson);
    }

    private static String getBetterErrorMessage(Throwable cause) {
        String betterMessage = cause.getMessage();

        if (cause instanceof ConnectException)
            betterMessage = "Connection refused. Please confirm that the URL is correct and that the Code Dx server is running.";
        else if (cause instanceof SSLHandshakeException)
            betterMessage = "The SSL Certificate presented by the server is invalid. If this is expected, please input the SHA1 fingerprint in the advanced options";
        else if (cause instanceof UnknownHostException)
            betterMessage = "Unknown host";

        return betterMessage;
    }
}

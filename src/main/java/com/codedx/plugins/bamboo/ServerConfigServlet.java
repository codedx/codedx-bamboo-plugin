package com.codedx.plugins.bamboo;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Replaces the XWork-based ServerConfigAction. The original class extended GlobalAdminAction,
 * which pulled in com.opensymphony.module.propertyset — a package blocked by Bamboo's
 * DmzResolverHook, preventing the plugin from loading.
 */
public class ServerConfigServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ServerConfigServlet.class);

    private static final String SAVED_BANNER_HTML =
        "<div id=\"codedx-saved-banner\" class=\"codedx-success-banner\">" +
        "  <i class=\"fas fa-check-circle\"></i>" +
        "  <span>Configuration saved successfully.</span>" +
        "  <button class=\"close-btn\" onclick=\"document.getElementById('codedx-saved-banner').style.display='none'\">&times;</button>" +
        "</div>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("doGet() called - serving admin config page");

        String url = ServerConfigManager.getUrl();
        String apiKey = ServerConfigManager.getApiKey();
        String fingerprint = ServerConfigManager.getFingerprint();

        String atlToken = req.getParameter("atl_token");
        if (atlToken == null) atlToken = "";

        boolean saved = "true".equals(req.getParameter("saved"));
        String savedBanner = saved ? SAVED_BANNER_HTML : "";

        String html = loadTemplate();
        html = html.replace("${url}", escapeHtml(url));
        html = html.replace("${apiKey}", escapeHtml(apiKey));
        html = html.replace("${fingerprint}", escapeHtml(fingerprint));
        html = html.replace("${atl_token}", escapeHtml(atlToken));
        html = html.replace("${savedBanner}", savedBanner);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("doPost() called - saving admin config");

        String url = req.getParameter("url");
        String apiKey = req.getParameter("apiKey");
        String fingerprint = req.getParameter("fingerprint");

        if (url != null) ServerConfigManager.setUrl(url.trim());
        if (apiKey != null) ServerConfigManager.setApiKey(apiKey.trim());
        if (fingerprint != null) ServerConfigManager.setFingerprint(fingerprint.trim());

        log.info("Configuration saved successfully");

        // PRG pattern: redirect back to GET with saved=true to show success banner
        resp.sendRedirect(req.getRequestURI() + "?saved=true");
    }

    private String loadTemplate() throws IOException {
        InputStream is = getClass().getResourceAsStream("/admin/serverConfig.ftl");
        if (is == null) {
            throw new IOException("Template not found: /admin/serverConfig.ftl");
        }
        try {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } finally {
            is.close();
        }
    }

    private static String escapeHtml(String value) {
        if (value == null) return "";
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}

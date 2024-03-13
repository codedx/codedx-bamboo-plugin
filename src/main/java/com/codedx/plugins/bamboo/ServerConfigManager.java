package com.codedx.plugins.bamboo;

import com.atlassian.bamboo.bandana.PlanAwareBandanaContext;
import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;
import com.codedx.client.ApiClient;
import com.codedx.plugins.bamboo.security.SSLContextFactory;
import org.apache.log4j.Logger;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerConfigManager implements Serializable {

    private static final Logger _logger = Logger.getLogger(ServerConfigManager.class);

    // Private fields
    private static BandanaManager bandanaManager = null;
    private static final BandanaContext GLOBAL_CONTEXT = PlanAwareBandanaContext.GLOBAL_CONTEXT;
    private static final String BANDANA_KEY =  "com.codedx.bambooplugin:Config";

    // This gets called automatically
    public ServerConfigManager(BandanaManager bandanaManager) {
        ServerConfigManager.bandanaManager = bandanaManager;
    }

    public static String getUrl() {

        String url = getData().url;
        _logger.info("getUrl: " + emptyIfNull(url));
        return url;
    }

    public static void setUrl(String url) {

        _logger.info("setUrl: " + emptyIfNull(url));

        GlobalData data = getData();
        data.url = url;
        saveData(data);
    }

    public static String getApiKey() {
        String apiKey = getData().apiKey;
        _logger.info("getApiKey: " + emptyIfNull(apiKey));
        return apiKey;
    }

    public static void setApiKey(String apiKey) {

        _logger.info("setApiKey: " + emptyIfNull(apiKey));

        GlobalData data = getData();
        data.apiKey = apiKey;
        saveData(data);
    }

    public static String getFingerprint() {
        String fingerprint = getData().fingerprint;
        _logger.info("getFingerprint: " + emptyIfNull(fingerprint));
        return fingerprint;
    }

    public static void setFingerprint(String fingerprint) {

        _logger.info("setFingerprint: " + emptyIfNull(fingerprint));

        GlobalData data = getData();
        data.fingerprint = fingerprint;
        saveData(data);
    }

    // Ease of use method to get a client configured correctly with the url, apiKey, and fingerprint loaded from the admin plug-in settings.
    public static ApiClient getConfiguredClient() {

        _logger.info("getConfiguredClient() called");

        return getConfiguredClient(getUrl(), getApiKey(), getFingerprint());
    }

    // Ease of use method to get a client configured correctly with the given url, apiKey, and fingerprint.
    public static ApiClient getConfiguredClient(String url, String apiKey, String fingerprint) {

        _logger.info("getConfiguredClient(...) called");

        if(url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
            _logger.info("Removing trailing foward slash in URL");
        }

        ApiClient cdxApiClient = new ApiClient();
        cdxApiClient.setBasePath(url);
        cdxApiClient.setApiKey(apiKey);

        if (fingerprint != null && !fingerprint.isEmpty()) {
            try {
                ClientBuilder clientBuilder = JerseyClientBuilder.newBuilder();
                Client client = clientBuilder.withConfig(cdxApiClient.getHttpClient().getConfiguration())
                        .sslContext(SSLContextFactory.getSSLContext(fingerprint))
                        .build();
                cdxApiClient.setHttpClient(client);
            } catch (Exception e) {
                _logger.error(e);
            }
        }
        return cdxApiClient;
    }

    // Helper method to tell us if the user configured settings in the admin page
    public static boolean getDefaultsSet() {

        _logger.info("getDefaultsSet(...) called");

        String[] settings = new String[] {
            getUrl(),
            getApiKey(),
            getFingerprint()
        };
        for (String setting : settings) {
            if (setting != null && !setting.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Helper method to tell if a url is formatted correctly
    public static boolean isURLValid(String url) {

        _logger.info("isURLValid: " + emptyIfNull(url));

        try {
            new URL(url);
        } catch (MalformedURLException e) {
            _logger.info("URL is not valid: " + emptyIfNull(url));
            return false;
        }
        _logger.info("URL is valid: " + emptyIfNull(url));
        return true;
    }

    // Fields we want to save
    private static class GlobalData implements Serializable {
        public String url;
        public String apiKey;
        public String fingerprint;
    }

    // Private helpers
    private static GlobalData getData() {
        GlobalData data = (GlobalData) bandanaManager.getValue(GLOBAL_CONTEXT, BANDANA_KEY);
        if (data == null) {
            data = new GlobalData();
        }
        return data;
    }

    private static void saveData(GlobalData data) {
        bandanaManager.setValue(GLOBAL_CONTEXT, BANDANA_KEY, data);
    }

    private static String emptyIfNull(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}

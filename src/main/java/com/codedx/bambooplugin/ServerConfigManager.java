package com.codedx.bambooplugin;

import com.atlassian.bamboo.bandana.PlanAwareBandanaContext;
import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;
import com.codedx.bambooplugin.security.BambooHostnameVerifierFactory;
import com.codedx.bambooplugin.security.SSLContextFactory;
import com.codedx.client.ApiClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.Serializable;

public class ServerConfigManager implements Serializable {

    // Private fields
    private static BandanaManager bandanaManager = null;
    private static final BandanaContext GLOBAL_CONTEXT = PlanAwareBandanaContext.GLOBAL_CONTEXT;
    private static final String BANDANA_KEY =  "com.codedx.bambooplugin:Config";

    // This gets called automatically
    public void setBandanaManager(BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;
    }

    public static String getUrl() {
        return getData().url;
    }

    public static void setUrl(String url) {
        GlobalData data = getData();
        data.url = url;
        saveData(data);
    }

    public static String getApiKey() {
        return getData().apiKey;
    }

    public static void setApiKey(String apiKey) {
        GlobalData data = getData();
        data.apiKey = apiKey;
        saveData(data);
    }

    public static String getFingerprint() {
        return getData().fingerprint;
    }

    public static void setFingerprint(String fingerprint) {
        GlobalData data = getData();
        data.fingerprint = fingerprint;
        saveData(data);
    }

    // Ease of use method to get a client configured correctly with the url, apiKey, and fingerprint loaded from the admin plug-in settings.
    public static ApiClient getConfiguredClient() {
        return getConfiguredClient(getUrl(), getApiKey(), getFingerprint());
    }

    // Ease of use method to get a client configured correctly with the given url, apiKey, and fingerprint.
    public static ApiClient getConfiguredClient(String url, String apiKey, String fingerprint) {

        if(url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }

        ApiClient cdxApiClient = new ApiClient();
        cdxApiClient.setBasePath(url);
        cdxApiClient.setApiKey(apiKey);

        if (fingerprint != null && !fingerprint.isEmpty()) {
            try {
                ClientBuilder clientBuilder = JerseyClientBuilder.newBuilder();
                Client client = clientBuilder.withConfig(cdxApiClient.getHttpClient().getConfiguration())
                        .hostnameVerifier(BambooHostnameVerifierFactory.getVerifier(url))
                        .sslContext(SSLContextFactory.getSSLContext(fingerprint))
                        .build();
                cdxApiClient.setHttpClient(client);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cdxApiClient;
    }

    // Helper method to tell us if the user configured settings in the admin page
    public static boolean getDefaultsSet() {
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
}

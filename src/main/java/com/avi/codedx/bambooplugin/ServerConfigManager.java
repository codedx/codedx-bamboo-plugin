package com.avi.codedx.bambooplugin;

import com.atlassian.bamboo.bandana.PlanAwareBandanaContext;
import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;

import java.io.Serializable;

public class ServerConfigManager implements Serializable {

    // Private fields
    private static BandanaManager bandanaManager = null;
    private static final BandanaContext GLOBAL_CONTEXT = PlanAwareBandanaContext.GLOBAL_CONTEXT;
    private static final String BANDANA_KEY =  "com.avi.codedx.bambooplugin:Config";

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

    // Fields we want to save
    private static class GlobalData implements Serializable {
        public String url;
        public String apiKey;
    }

    // Helpers
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

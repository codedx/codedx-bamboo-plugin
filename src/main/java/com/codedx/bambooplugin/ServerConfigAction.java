package com.codedx.bambooplugin;

import com.atlassian.bamboo.configuration.GlobalAdminAction;
import com.atlassian.bamboo.ww2.aware.permissions.GlobalAdminSecurityAware;
import com.atlassian.spring.container.ContainerManager;

public class ServerConfigAction extends GlobalAdminAction implements GlobalAdminSecurityAware {

    private String url;
    private String apiKey;
    private String fingerprint;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apikey) {
        this.apiKey = apikey;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String edit() {
        // Load config values
        setApiKey(ServerConfigManager.getApiKey());
        setUrl(ServerConfigManager.getUrl());
        setFingerprint(ServerConfigManager.getFingerprint());
        System.out.println(ContainerManager.getInstance().getContainerContext());
        return "success";
    }

    public String save() {
        // Save config values
        ServerConfigManager.setApiKey(this.getApiKey());
        ServerConfigManager.setUrl(this.getUrl());
        ServerConfigManager.setFingerprint(this.getFingerprint());
        return "success";
    }
}

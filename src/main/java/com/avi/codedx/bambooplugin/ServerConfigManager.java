package com.avi.codedx.bambooplugin;

import com.atlassian.spring.container.ContainerManager;

import java.io.Serializable;

public class ServerConfigManager implements Serializable {
    private String url;
    private String apikey;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public static ServerConfigManager getInstance() {
        ServerConfigManager serverConfigManager = new ServerConfigManager();
        System.out.println(ContainerManager.getInstance().getContainerContext());
        ContainerManager.autowireComponent(serverConfigManager);
        return serverConfigManager;
    }
}

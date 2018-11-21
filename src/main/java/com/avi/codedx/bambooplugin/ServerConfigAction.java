package com.avi.codedx.bambooplugin;

import com.atlassian.bamboo.configuration.GlobalAdminAction;
import com.atlassian.bamboo.ww2.aware.permissions.GlobalAdminSecurityAware;
import com.atlassian.spring.container.ContainerManager;
import org.springframework.beans.factory.annotation.Autowired;

public class ServerConfigAction extends GlobalAdminAction implements GlobalAdminSecurityAware {
    @Autowired
    private transient ServerConfigManager serverConfigManager;

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

    private String url;
    private String apikey;

    public ServerConfigAction(ServerConfigManager serverConfigManager)
    {
        this.serverConfigManager = serverConfigManager;
    }

    public String edit()
    {
        // load config values
        setApikey(serverConfigManager.getApikey());
        setUrl(serverConfigManager.getUrl());
        System.out.println(ContainerManager.getInstance().getContainerContext());
        return "success";
    }

    public String save()
    {
        // save config values
        serverConfigManager.setApikey(this.getApikey());
        serverConfigManager.setUrl(this.getUrl());
        return "success";
    }
}

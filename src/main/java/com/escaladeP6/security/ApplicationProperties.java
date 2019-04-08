package com.escaladeP6.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {

    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    String appConfigPath = rootPath + "application.properties";

    String urlPG;
    String userPG;
    String passwordPG;


    public Properties appProps() throws IOException {
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        return appProps;
    }

    public ApplicationProperties() {
    }

    public String getUrlPG() throws IOException {
        String urlPG = appProps().getProperty("spring.datasource.url");
        return urlPG;
    }

    public String getUserPG() throws IOException {
        String userPG = appProps().getProperty("spring.datasource.username");
        return userPG;
    }

    public String getPasswordPG() throws  IOException {
        String passPG = appProps().getProperty("spring.datasource.password");
        return passPG;
    }
}

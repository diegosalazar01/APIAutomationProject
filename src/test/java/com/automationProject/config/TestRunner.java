package com.automationProject.config;

import lombok.Getter;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestRunner {

    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties PROPERTIES = new Properties();

    @Getter
    private static String baseUrl;
    @Getter
    private static String apiKey;

    @BeforeSuite
    public void setUpEnvironment() {
        loadProperties();
        baseUrl = PROPERTIES.getProperty("url.base");
        apiKey = PROPERTIES.getProperty("apikey");
    }

    private void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

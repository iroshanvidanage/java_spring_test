package com.example.test.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private static Properties g_oProperties;
    private static String sData;
    private static final String propertyFile = "config/properties.ini";
    private static final String appFile = "config/app.properties";

    private Settings() {

    }

    public static void load() {
        InputStream oIn;

        try {
            g_oProperties = new Properties();
            oIn = new FileInputStream(propertyFile);
            g_oProperties.load(oIn);

        } catch (Exception ignored) {

        }

        oIn = null;

    }

}

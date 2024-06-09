package com.example.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Settings {

    private static final Logger logger = LoggerFactory.getLogger(Settings.class);
    private static Properties propSet = new Properties();
    private static String sData;
//    private static final String propertyFile = "config/properties.ini";
//    private static final String appFile = "config/app.properties";
    private static final String propFile = "src/main/resources/application.properties";

    private static String smKey;
    private static String ssmKey;

    public Settings() {

    }

    public void load() {
        String abs_path = new File(propFile).getAbsolutePath();
        logger.info("[Settings.java:29] Absolute path of properties file: " + abs_path);

        try (InputStream oIn = new FileInputStream(abs_path)) {

            logger.info("[Settings.java:33] Loading property file for data selection.");
            propSet.load(oIn);
            setSmKey(propSet.getProperty("SM-KEY"));
            setSsmKey(propSet.getProperty("SSM-KEY"));
            logger.info("[Settings.java:37] Loading parameters {} & secrets {}", getSsmKey(), getSmKey());

//            List<String> smKeyList = Arrays.asList(smKey.split(","));
//            logger.info("[Settings.java:39] Parameters list {}", smKeyList);

            for(Map.Entry<Object, Object> prop : propSet.entrySet()) {
                String value = (String) prop.getValue();
                if(value.contains("/sm-") && !value.equals("SM-KEY")) {
//                    logger.info("[Settings.java:43] Parameter {} loaded", prop);
                    AwsSMConnector.getParaValue(value);
                }

                if(value.contains("/ssm-") && !value.equals("SSM-KEY")) {
                    logger.info("[Settings.java:50] Parameter {} loaded", value);
                }
            }

        } catch (Exception e) {
            logger.error("[Settings.java:55] Error loading property file.", e);
        }

    }

    public void setSsmKey(String ssmKey) {
        this.ssmKey = ssmKey;
    }

    public void setSmKey(String smKey) {
        this.smKey = smKey;
    }

    public static String getSsmKey() {
        return ssmKey;
    }

    public static String getSmKey() {
        return smKey;
    }

    public static String getValue(String s) {
        try {
            sData = propSet.getProperty(s);
            return sData;
        } catch (Exception e) {
            logger.error("[Settings.java:81]", e);
            return null;
        }
    }

//    public static int getInt(String s) {
//        try {
//            sData = propSet.getProperty(s);
//            return (Integer.parseInt(sData));
//        } catch (Exception e) {
//            logger.error(" {} ", e);
//        }
//    }
}

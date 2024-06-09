package com.example.test.util;

//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AwsSMConnector {
    private static final Logger logger = LoggerFactory.getLogger(AwsSMConnector.class);
//    private static SecretsManagerClient secretsManagerClient;
    private static String clientConnection;
    private static String smKey;
    private static List<String> smKeyList;

    private static void initializeSMClient() {
        if (smKey == null) {
            smKey = Settings.getSmKey();
            setSmKeyList();
        }
        if (clientConnection == null) {
            String region = Settings.getValue("AWS_REGION");
            clientConnection = "Open";
        }
    }

    private static void closeConnection() {
        try {
            if (clientConnection != null) {
                clientConnection = null;
            }
        } catch (Exception e) {
            logger.error("[AwsSMConnector.java:24] Error in closing ssm client.", e);
        }
    }

//    private static JsonObject getSecret(String secretName) {
    private static String getSecret(String secretName) {
        String secretValue = null;
//        JsonObject secretJson = null;
        logger.info("[AwsSMConnector.java:43] Getting Secret {}", secretName);

        try {
            initializeSMClient();

            secretValue = "Secret value Obtained";
        } catch (Exception e) {
            logger.error("[AwsSMConnector.java:50]", e);
        }
        return secretValue;
    }

    public static String getParaValue(String paraName){
//        for (int i=0; i < smKeyList.size(); i++) {
//            String smKeyProp = smKeyList.get(i);
//            String keyValue = getSecret(paraName);
//            logger.info("[AwsSMConnector.java:60] Parameter {} loaded with value {} .", smKeyProp, keyValue);
//        }

        String keyValue = getSecret(paraName);
        logger.info("[AwsSMConnector.java:60] Parameter {} loaded with value {} .", paraName, keyValue);
        return keyValue;
    }

    private static void setSmKeyList() {
        if (smKeyList == null) {
            List<String> smKeyList = Arrays.asList(smKey.split(","));
            logger.info("[AwsSMConnector.java:67] Parameters list {}", smKeyList);
        }
    }

}

package com.donesvad.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.donesvad.dto.Package;
import com.donesvad.enums.ConfigProperty;

public class ConfigManager {
    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("environment", "test"); // Default to 'test'
        try (FileInputStream fis =
            new FileInputStream(
                "src"
                    + File.separator
                    + "test"
                    + File.separator
                    + "resources"
                    + File.separator
                    + "config"
                    + File.separator
                    + env
                    + ".properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load environment configuration for: " + env, e);
        }
    }

    public static String get(ConfigProperty key) {
        if (!properties.containsKey(key.getValue())) {
            throw new RuntimeException("Property not found: " + key.getValue());
        }
        return properties.getProperty(key.getValue());
    }

    public static Package getPackageTestData(String packageKey) {
        String title = properties.getProperty(packageKey + "." + ConfigProperty.TITLE.getValue());
        String coverage = properties.getProperty(packageKey + "." + ConfigProperty.COVERAGE.getValue());
        String data = properties.getProperty(packageKey + "." + ConfigProperty.DATA.getValue());
        String validity = properties.getProperty(packageKey + "." + ConfigProperty.VALIDITY.getValue());
        String price = properties.getProperty(packageKey + "." + ConfigProperty.PRICE.getValue());

        if (title == null || coverage == null || data == null || validity == null || price == null) {
            throw new RuntimeException("Missing some properties for: " + packageKey);
        }

        return Package.builder().title(title).coverage(coverage).data(data).validity(validity).price(price).build();
    }
}

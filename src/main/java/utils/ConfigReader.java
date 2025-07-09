package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();  // ✅ Always initialized

    public static void loadConfig() {
        try {
        	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/config.properties");

            prop.load(fis);
        } catch (IOException e) {
            System.out.println("❌ Failed to load config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        if (prop.isEmpty()) {  // ✅ safer than checking null
            loadConfig();
        }
        return prop.getProperty(key);
    }
}

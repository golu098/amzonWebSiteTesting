package rev.project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    private static final Properties properties;

    // Static block to load the properties when the class is loaded
    static {
        properties = new Properties();

        try (FileInputStream input = new FileInputStream("src/main/resources/config/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace(); // Log or handle the exception properly
        }
    }

    // Get property value by key
    public static String accessUrl(String key) {
        return properties.getProperty(key);
    }
}

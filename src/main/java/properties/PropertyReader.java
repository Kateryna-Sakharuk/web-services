package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/TestData.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    public static String getProperty(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalStateException("Property value for key '" + key + "' is null");
        }
        return value;
    }
}

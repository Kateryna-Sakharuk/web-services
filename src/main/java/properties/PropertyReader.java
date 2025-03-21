package properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final Properties properties = new Properties();

    public PropertyReader(String testData) {
        loadProperties(testData);
    }

    @BeforeSuite
    @Parameters("testData")
    public static void loadProperties(String testData) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/properties/" + testData;
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
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

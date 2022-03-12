package builders;

import java.util.Properties;

public class PropertiesBuilder {
    protected Properties properties;

    public PropertiesBuilder() {
        properties = new Properties();
    }
    public PropertiesBuilder setProperty(String key, String value) {
        properties.setProperty(key, value);
        return this;
    }
    public PropertiesBuilder setProperty(String key, int value) {
        properties.setProperty(key, Integer.toString(value));
        return this;
    }
    public PropertiesBuilder setProperty(String key, boolean value) {
        properties.setProperty(key, Boolean.toString(value));
        return this;
    }

    public Properties getProperties() {
        return properties;
    }
}

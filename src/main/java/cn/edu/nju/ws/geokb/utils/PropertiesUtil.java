package cn.edu.nju.ws.geokb.utils;

import cn.edu.nju.ws.geokb.exception.ConfigException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sloriac on 16/3/9.
 * <p>
 * The util class for reading properties files.
 */
public class PropertiesUtil {

    private Properties properties;

    /**
     * Don`t let anyone to initialize this class without parameters.
     */
    private PropertiesUtil() {
    }

    /**
     * The only constructor can be used.
     *
     * @param file your properties file
     * @throws IOException
     */
    public PropertiesUtil(String file) throws IOException {
        ClassLoader classLoader = PropertiesUtil.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(file);
        if (inputStream == null) {
            throw new ConfigException("No config file : " + file + "founded.");
        }
        properties.load(inputStream);
    }


    /**
     * Get the value by it`s key from the default config.
     *
     * @param key The value`s key.
     * @return the value if it is existed otherwise null.
     */
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
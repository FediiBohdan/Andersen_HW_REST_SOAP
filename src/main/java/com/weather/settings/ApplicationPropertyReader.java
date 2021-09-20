package com.weather.settings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationPropertyReader {
    private static ApplicationPropertyReader instance;

    public static ApplicationPropertyReader getInstance() {
        if (instance == null) {
            instance = new ApplicationPropertyReader();
        }
        return instance;
    }

    private Map<String, String> properties = this.setPropsApps();

    public Map<String, String> setPropsApps() {
        Map<String, String> propsApps = new HashMap<>();
        String propFileName = "config.properties";
        try (InputStream input = ApplicationPropertyReader.class
                .getClassLoader()
                .getResourceAsStream(propFileName)) {

            Properties prop = new Properties();

            if (input != null) {
                prop.load(input);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            propsApps.put("db_hostname", prop.getProperty("andersen.db.pg.host"));
//            propsApps.put("db_hostname",prop.getProperty("andersen.db.pg.hostW"));
            propsApps.put("db_port", prop.getProperty("andersen.db.pg.port"));
            propsApps.put("db_username", prop.getProperty("andersen.db.pg.user"));
            propsApps.put("db_user_password", prop.getProperty("andersen.db.pg.password"));
            propsApps.put("db_name", prop.getProperty("andersen.db.pg.dbname"));

        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        return propsApps;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

}
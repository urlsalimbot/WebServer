package com.WebServTest.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
    private static Properties prop;

        static {
        try {
            prop = new Properties();

            InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream("configs/config.properties");
            prop.load(input);

            assert input != null;
            input.close();
        }
        catch (IOException ex) {
           logger.warn(ex.getMessage());
        }
    }

    public static Properties getConfig(){
        return prop;
    }
}

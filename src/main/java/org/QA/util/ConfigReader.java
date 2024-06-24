package org.QA.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties init_prop() {
        prop = new Properties();

        try {
            FileInputStream ip  = new FileInputStream("./src/test/java/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }

}

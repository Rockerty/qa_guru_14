package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final WebDriverConfig webDriverConfig =
            ConfigFactory.create(WebDriverConfig.class, System.getProperties());
}
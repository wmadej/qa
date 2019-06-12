package com.jsystem.qa.frontend;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    //pobranie z pliku konfiguracyjnego w resources
    private static final Config CONFIG = ConfigFactory.load("config.conf");
    private static final String ENVIRONMENT = CONFIG.getString("environment");
    private static final String BROWSER = CONFIG.getString("browser");
    private static final String MACHINE = CONFIG.getString("machine");

    private static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    public static final String BASE_URL = ENV.getString("baseUrl");
    public static final String LOGIN = ENV.getString("login");
    public static final String PASSWORD = ENV.getString("password");
//Alt + Ins - menu z podpowiedzią. Dodaje metodę pblic, aby zmienna private była widoczna jako public
    public static String getBROWSER() {
        return BROWSER;
    }

    public static String getMACHINE() {
        return MACHINE;
    }
}

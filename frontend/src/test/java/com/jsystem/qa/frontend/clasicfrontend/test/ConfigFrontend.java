package com.jsystem.qa.frontend.clasicfrontend.test;

import com.jsystem.qa.frontend.Configuration;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigFrontend {
    WebDriver driver;
    String chromePath;
    String fireFoxPath;

    {
        try {
            chromePath = Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath();
            fireFoxPath = Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe").toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }



    @BeforeAll
    public static void setUpAll() {
        //jak jest dostęp do sieci to od-komntować i używać web driver
        //        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpEach() {
        //jak jest dostęp do sieci to zakomntować i używać web driver
        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", fireFoxPath);
//koniec komentowanie
        String browser = Configuration.getBROWSER();

        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")){
            driver = new FirefoxDriver();
        }
        setDriver();
        driver.get(Configuration.BASE_URL);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

     private void setDriver() {
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         //driver.get("http://wordpress.com");
         driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
     }


    }

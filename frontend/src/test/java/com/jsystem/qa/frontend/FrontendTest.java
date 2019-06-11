package com.jsystem.qa.frontend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class FrontendTest {
    @BeforeAll
            public static void setUpAll(){
        System.setProperty("webdriver.gecko.driver","D:/firefox/geckodriver.exe");

    }



    WebDriver driver;
    @Test
    public void firstFrontTest(){
        //wersja na sztywno
        //System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
    //    WebDriverManager.chromedriver();
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://wordpress.com");
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//
//        }
        WebElement login = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in  a.x-nav-link.x-link"));
        WebElement span1 = driver.findElement(By.cssSelector("#lpc-headline h1 span:nth-child(1)"));

        assertTrue(span1.isDisplayed());
        assertEquals(span1.getText(), "Build a website,");

        assertTrue(login.isDisplayed());
        assertEquals(login.getText(), "Log In");

        login.click();

        driver.quit();

    }


}

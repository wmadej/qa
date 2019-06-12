package com.jsystem.qa.frontend.test;

import com.jsystem.qa.frontend.test.ConfigFrontend;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WindowsTest extends ConfigFrontend {

    @Test
    public void testWindows() {
        //ze strony: https://github.com/PawelDub/testautomation/blob/master/src/test/java/com/jsystems/frontend/tests/WindowsTest.java
        //id okna w przeglądarce
        String firstPageWindowHandle;
        String secondTestWindowHandle = null;

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);
//czeka  aż obiekt (link: Open page in a new window) sie pokaże
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

        firstPageWindowHandle = driver.getWindowHandle();

        int hyperlinkYCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getY();
        int hyperlinkXCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getX();
//wykona kod java script'owy (tutaj selenium nie wspiera skt=rolowania)
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in a new window")));

        driver.findElement(By.linkText("Open page in a new window")).click();

        Set<String> testPageWindowHandle = driver.getWindowHandles();
//pobiera id wszystkich otwartych okien
        for (String windowHandle : testPageWindowHandle) {
            if (!firstPageWindowHandle.equals(windowHandle)) {
                secondTestWindowHandle = windowHandle;
            }
        }

        driver.switchTo().window(secondTestWindowHandle);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));
//zamyka 2-gie okno
        driver.switchTo().window(secondTestWindowHandle).close();
//przełącza sie na 1-sze okno
        driver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

    }
    @Test
    public void frameTest(){
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("testframe")));

        WebElement testframe = driver.findElement(By.name("testframe"));
//przełącza sie na frame
        driver.switchTo().frame(testframe);

        String expectedFrameText =driver.findElement(By.id("testpagelink")).getText();
        String actualFrameText = "My frame text";

        if(actualFrameText.equals(expectedFrameText)){
            System.out.println("Found my frame text");
        }
        else {
            System.out.println("Did not find my frame text");
        }

        driver.switchTo().parentFrame();
    }
}

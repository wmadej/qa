package com.jsystem.qa.frontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
//Alt+Insert -> Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForVisibilityOfElement(WebElement element, int maxWaitTime){
        WebDriverWait wait = new WebDriverWait(driver,maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

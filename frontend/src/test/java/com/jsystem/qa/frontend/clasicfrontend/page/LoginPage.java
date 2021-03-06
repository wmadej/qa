package com.jsystem.qa.frontend.clasicfrontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "usernameOrEmail")
    public WebElement emailInput;
    //public WebElement emailInput = driver.findElement(By.id("usernameOrEmail"));

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement buttonContinue;
    //public WebElement buttonContinue = driver.findElement(By.cssSelector(".button.form-button.is-primary"));

    @FindBy(id = "password")
    public WebElement password;
    //public WebElement password = driver.findElement(By.cssSelector("#lpc-headline h1 span:nth-child(1)"));




}

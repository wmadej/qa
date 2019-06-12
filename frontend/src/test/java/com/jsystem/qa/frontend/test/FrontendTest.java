package com.jsystem.qa.frontend.test;

import com.jsystem.qa.frontend.Configuration;
import com.jsystem.qa.frontend.page.LoginPage;
import com.jsystem.qa.frontend.page.MainWordpressPage;
import com.jsystem.qa.frontend.page.UserPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import sun.applet.Main;

import static com.jsystem.qa.frontend.Configuration.LOGIN;
import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class FrontendTest extends ConfigFrontend{

    MainWordpressPage wordpressPage;
    LoginPage loginPage;
    UserPage userPage;
    @Test

    public void firstFrontTest(){
        wordpressPage = new MainWordpressPage(driver);
        assertTrue(wordpressPage.span1.isDisplayed());
        assertEquals(wordpressPage.span1.getText(), "Build a website,");
        assertTrue(wordpressPage.login.isDisplayed());
        assertEquals(wordpressPage.login.getText(), "Log In");
        wordpressPage.login.click();
    }

    @Test
    public void loginTest(){
        login();
        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);
        //może przenieść do alertu
        //Alert alert = driver.switchTo().alert();
        //alert.accept()
        //driver.switchTo().alert();
        assertTrue(userPage.userAvatar.isDisplayed());
    }





    private void login() {
        wordpressPage = new MainWordpressPage(driver);
        wordpressPage.waitForVisibilityOfElement(wordpressPage.login, 30);
        wordpressPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(LOGIN);
        loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.password, 30);
        loginPage.password.clear();
        loginPage.password.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();
    }

    @Test
    private void loginActionTest(){
        wordpressPage = new MainWordpressPage(driver);
        wordpressPage.waitForVisibilityOfElement(wordpressPage.login, 30);
        wordpressPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(LOGIN);
        loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.password, 30);
        Actions action = new Actions(driver);
                action
                        .moveToElement(loginPage.emailInput)
                        .sendKeys(Configuration.LOGIN)
                        .sendKeys(Keys.chord(Keys.ENTER))
                        .build()
                        .perform();

        loginPage.waitForVisibilityOfElement(loginPage.password, 30);
        assertTrue(loginPage.buttonContinue.getText().equals("Log In"));


    }





}

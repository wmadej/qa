package com.jsystem.qa.frontend.cucumber.steps;

import com.jsystem.qa.frontend.Configuration;
import com.jsystem.qa.frontend.cucumber.CucumberStepConfig;
import com.jsystem.qa.frontend.cucumber.page.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.jsystem.qa.frontend.Configuration.LOGIN;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginSteps {

    WebDriver driver;
    MainWordpressPage wordpressPage;
    LoginPage loginPage;
    UserPage userPage;
    UserProfilePage userProfilePage;
    NotificationPage notificationPage;

    public LoginSteps (CucumberStepConfig stepConfig){
        driver = stepConfig.setUp();

    }

    //to jest REGEXP czyli tekst od: ^ do $
    @Given("^User start on main page$")
    public void userStartOnMainPage() {
        driver.get(Configuration.BASE_URL);
        
    }

    @When("^User loged In to the user page$")
    public void userLogedInToTheUserPage() {
        login();
        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);
        assertTrue(userPage.userAvatar.isDisplayed());
    }

    @Then("^User can modified user profile$")
    public void userCanModifiedUserProfile() {
        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave,120);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",userProfilePage.buttonSave);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave,120);
        assertFalse(userProfilePage.buttonSave.isEnabled());


    }


    @Given("^User start on page \"([^\"]*)\"$")
    public void userStartOnPage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.get(arg0);
        //userProfilePage.waitForVisibilityOfElement(userProfilePage.notification,30);
        //assertTrue(userProfilePage.notification.isDisplayed());
    }

    @Then("^User can modified notifications$")
    public void userCanModifiedNotifications() {
        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.notification, 120);
        userProfilePage.notification.click();
        notificationPage = new NotificationPage(driver);
        notificationPage.waitForVisibilityOfElement(notificationPage.findCheckbox, 120);
        assertTrue(notificationPage.findCheckbox.isSelected());
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
}

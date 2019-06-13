package com.jsystem.qa.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage extends BasePage {
    public UserProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".button.form-button.is-primary")
    public WebElement buttonSave;
    //mvn clean install -Dcucumber.options="--tags @wordpress"
    @FindBy(css=".material-icon.material-icon-notifications")
    public WebElement notification;
}

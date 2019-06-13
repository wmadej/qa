package com.jsystem.qa.frontend.cucumber.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Alt+Ins->Constructor
public class MainWordpressPage extends BasePage{
    public MainWordpressPage(WebDriver driver) {
        //super wywołuje constructor klasy extends - czyli BasePage
        super(driver);
        //inicjowanie zmiennych na stronie kiedy sie do nich odwolujemy
        PageFactory.initElements(driver, this);
    }

    //inicjowanie zmiennych na stronie kiedy sie do nich odwolujemy
    @FindBy(css = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in  a.x-nav-link.x-link")
    public WebElement login;
    //public WebElement login = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in  a.x-nav-link.x-link"));
    @FindBy(css = "#lpc-headline h1 span:nth-child(1)")
    public WebElement span1;
    //public WebElement span1 = driver.findElement(By.cssSelector("#lpc-headline h1 span:nth-child(1)"));

}

package com.pagepkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.basepkg.BaseClass.driver;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwrd;

    @FindBy(xpath = "//*[@id=\"login\"]")
    WebElement loginbutn;

    @FindBy(xpath = "//*[@id=\"register\"]")
    WebElement register;


    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public String verifylogintitle(){
        String title =driver.getTitle();
        return title;
    }

    public boolean verifyregistr(){
        boolean regstr = register.isDisplayed();
        return regstr;
    }
    public LandingPage loginmethd(String user, String paswrd){
        username.sendKeys(user);
        passwrd.sendKeys(paswrd);
        loginbutn.click();
        return new LandingPage();
    }
}

package com.pagepkg;

import com.basepkg.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"logo\"]")
    WebElement wbqa;

    @FindBy(xpath = "//*[@id=\"headerfblogin\"]")
    WebElement freestudent;


    @FindBy(xpath = "//*[@id=\"wblhead\"]")
    WebElement wbl;

    @FindBy(xpath = "//*[@id=\"loginButton\"]")
    WebElement loginbutton;


    public HomePage(){
        // creating constructr
        PageFactory.initElements(driver,this);
        logger=Logger.getLogger(HomePage.class);
        logger.info("we are in home page");
    }

    public String verifyTitle(){
      String title= driver.getTitle();
      return title;
    }

    public boolean verifyWblLogo(){
        boolean logo =wbqa.isDisplayed();
        return logo;
    }

    public boolean verifyStudent(){
        boolean studnt = freestudent.isDisplayed();
        return  studnt;
    }

    public LoginPage verifyLoginbutn(){
         loginbutton.click();
         return new LoginPage();
    }

}

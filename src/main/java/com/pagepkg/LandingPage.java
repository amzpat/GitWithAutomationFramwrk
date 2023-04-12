package com.pagepkg;

import com.basepkg.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LandingPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"wblhead\"]")
    WebElement wbl;

    @FindBy(xpath = "/html/body/header/div[2]/div/div/ul/p[2]/a")
    WebElement mail;


    public LandingPage(){
        PageFactory.initElements(driver,this);

    }

    public boolean checkwbl(){
        boolean logo = wbl.isSelected();
        return logo;


    }
   public boolean checkmailid(){
        boolean email = mail.isDisplayed();
        return email;

   }
}

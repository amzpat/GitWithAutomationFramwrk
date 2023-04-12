package com.pageTestpkg;

import com.basepkg.BaseClass;
import com.pagepkg.HomePage;
import com.pagepkg.LandingPage;
import com.pagepkg.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingpageTest extends BaseClass {

    HomePage home;
    LoginPage login;
    LandingPage land;

    public LandingpageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialisation();
        home = new HomePage();
        login = new LoginPage();
        land = new LandingPage();
        home.verifyLoginbutn();

        login.loginmethd(prop.getProperty("username"),prop.getProperty("passwrd"));
        boolean land =login.verifyregistr();
        logger.info("landing page");

    }
    @AfterMethod
    public void Teardown() {
        driver.close();
    }
    @Test
    public void Testwbl(){
        boolean wb =land.checkwbl();
       // Assert.assertTrue(wb);
        Assert.assertFalse(wb);
    }
    @Test
    public void Testmailid(){
        boolean mail = land.checkmailid();
        Assert.assertTrue(mail);
    }
}

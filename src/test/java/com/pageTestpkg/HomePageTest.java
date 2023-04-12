package com.pageTestpkg;

import com.basepkg.BaseClass;
import com.pagepkg.HomePage;
import com.pagepkg.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    HomePage home;
    LoginPage login;


    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initialisation();
        home = new HomePage();

    }
    @Test(priority = 1)
    public void TestTitle(){
        String actual = home.verifyTitle();
        String expected ="QA/QE/SDET Training.";
        Assert.assertEquals(expected,actual);


    }
    @Test(priority = 2)
    public void verifywblLogoTest(){
        boolean logo = home.verifyWblLogo();
        Assert.assertTrue(logo);
       // Assert.assertFalse(logo);

    }
    @Test(priority = 3)
    public void verifyStudntTest(){
       boolean studnt= home.verifyStudent();
       Assert.assertTrue(studnt);


    }
    @Test(priority = 4)
     public void Testloginbtn(){
        home.verifyLoginbutn();



     }
     @AfterMethod
     public void TearDown(){
        driver.quit();
     }
}

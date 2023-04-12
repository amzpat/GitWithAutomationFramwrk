package com.pageTestpkg;

import com.basepkg.BaseClass;
import com.pagepkg.HomePage;
import com.pagepkg.LandingPage;
import com.pagepkg.LoginPage;
import com.utilitpkg.Utilis;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginpageTest extends BaseClass {

    HomePage home;
    LoginPage login;
    LandingPage land;

    public LoginpageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialisation();
        home = new HomePage();
        login = new LoginPage();
        land = new LandingPage();
        home.verifyLoginbutn();

    }

    @Test(priority = 1)
    public void validatelogintitlTest() {
        String actual = login.verifylogintitle();
        String expected = "QA/QE/SDET Training.";
        Assert.assertEquals(expected, actual);
    }

    @Test(priority = 2)
    public void loginTest() {
        land = login.loginmethd(prop.getProperty("username"), prop.getProperty("passwrd"));

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] LoginDataDriven(){
        Object data[][] = Utilis.getExcelData("testdata.xlsx", "sheet1");
        return data;

    }

    @Test(dataProvider ="LoginDataDriven")
    public void LoginDataTest(String username, String password){

        login.loginmethd(username, password);
    }

}


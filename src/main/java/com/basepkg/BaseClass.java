package com.basepkg;

import com.utilitpkg.Utilis;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;

    public static Logger logger= null;
    public BaseClass()  {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\mpm26\\eclipse-workspace\\AutomationFramwrk1\\src\\main\\java\\com\\configpkg\\Config.Property");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            }
        String log4jpath =System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jpath);
        }
    public static void initialisation() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Utilis.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Utilis.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));


    }
}
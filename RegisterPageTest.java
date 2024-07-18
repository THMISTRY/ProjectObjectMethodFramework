package com.demo.nopcommerce;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterPageTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    RegisterPage registerPage;

    @BeforeClass
    void openBrowser(){
        basePage= new BasePage();
        prop = basePage.initialiseProperties();
        String webengine = prop.getProperty("Browser");
        driver = basePage.initialiseDriver(webengine);
        driver.get(prop.getProperty("URL"));
        registerPage = new RegisterPage(driver);
    }

    @Test
    void registerTest(){
        registerPage.clickonRegisterLink();
        registerPage.doRegister(prop.getProperty("FirstName"), prop.getProperty("LastName"),
                prop.getProperty("Daydateofbirth"), prop.getProperty("Monthdateofbirth"),
                prop.getProperty("Yeardateofbirth"), prop.getProperty("Email"),
                prop.getProperty("CompanyName"), prop.getProperty("Password"),
                prop.getProperty("confirmPassword"));

    }

    @AfterClass
    void closeBrowser(){
        driver.quit();
    }
}

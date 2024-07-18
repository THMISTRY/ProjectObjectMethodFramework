package com.demo.nopcommerce;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    LoginPage loginPage;

    @BeforeClass
    void openBrowser(){
        basePage =new BasePage();
        prop = basePage.initialiseProperties();
        String webengine =prop.getProperty("Browser");
        driver = basePage.initialiseDriver(webengine);
        driver.get(prop.getProperty("URL"));
        loginPage = new LoginPage(driver);

    }

    @Test
    void loginTest(){
        loginPage.clickonLoginLink();
        loginPage.getLoginPageTitle();
        loginPage.doLogin(prop.getProperty("Email"), prop.getProperty("Password"));
    }

    @AfterClass
    void closeBrowser(){
        driver.quit();
    }

}

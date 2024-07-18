package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    Utils utils;

// 1. Create your page object/ object repository in the form of by locators
    By loginlink = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By emailId = By.id("Email");
    By password= By.id("Password");
    By loginBtton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");

//    2. Create a constructor of the class

    public LoginPage (WebDriver driver){
        this.driver = driver;
        utils = new Utils(driver);

    }

//    3. Page Actions
    public void clickonLoginLink(){
        utils.doclick(loginlink);

    }

    public String getLoginPageTitle(){
        String lpTitle = driver.getTitle();
        System.out.println("Login Page Title: " +lpTitle);
        return lpTitle;
    }

    public void doLogin(String Username, String Password){
        utils.doSendKey(emailId, Username);
        utils.doSendKey(password, Password);
        utils.doclick(loginBtton);
    }

}

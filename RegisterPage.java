package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    Utils utils;

//    Create your page object/ repository in the form of locators
    By registerlink = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    By selectgender = By.id("gender-female");
    By firstname = By.id("FirstName");
    By lastname = By.id("LastName");
    By daydateofbirth = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]");
    By monthdateofbirth = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    By yeardateofbirth = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    By emailid = By.xpath("//*[@id=\"Email\"]");
    By companyname = By.id("Company");
    By newsletter = By.id("Newsletter");
    By password = By.id("Password");
    By confirmpassword = By.id("ConfirmPassword");
    By registerbutton = By.id("register-button");

//    create constructor of the class

    public RegisterPage (WebDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

//    Page actions

    public void clickonRegisterLink(){
        utils.doclick(registerlink);
    }

    public void doRegister(String FirstName, String LastName, String Daydateofbirth, String Monthdateofbirth,
                           String Yeardateofbirth, String Email, String Companyname, String Password, String Confpassword){
        utils.doclick(selectgender);
        utils.doSendKey(firstname, FirstName);
        utils.doSendKey(lastname, LastName);
        utils.doSendKey(daydateofbirth, Daydateofbirth);
        utils.doSendKey(monthdateofbirth, Monthdateofbirth);
        utils.doSendKey(yeardateofbirth, Yeardateofbirth);
        utils.doSendKey(emailid, Email);
        utils.doSendKey(companyname, Companyname);
        utils.doclick(newsletter);
        utils.doSendKey(password, Password);
        utils.doSendKey(confirmpassword, Confpassword);
        utils.doclick(registerbutton);
    }


}

package com.demo.nopcommerce.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties prop;
    FileInputStream file;


    public WebDriver initialiseDriver(String browserName){
        if(browserName.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equals(("Edge"))){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browserName.equals("Fire Fox")){
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }else {
            System.out.println("Browser is not matched");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;

    }

    public Properties initialiseProperties(){
        prop = new Properties();
        try {
            file = new FileInputStream("C:\\Users\\Windows 10\\IdeaProjects\\PageObjectModelFramework\\src\\test\\resources\\TestData\\config.properties");
            prop.load(file);
        }catch (FileNotFoundException e){
            System.out.println("Config file is not found");
        }catch (IOException e){
            System.out.println("Properties can not be loaded");
        }

        return prop;

    }

}

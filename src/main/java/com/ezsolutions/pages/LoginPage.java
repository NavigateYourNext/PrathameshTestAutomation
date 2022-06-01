package com.ezsolutions.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.ezsolutions.base.BaseClass;

public class LoginPage extends BaseClass {

    private static Logger logger = LogManager.getLogger(LoginPage.class);
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorButton = By.className("error-button");

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    private ProductsPage doLogin(){
        return new ProductsPage();
       
    }

    public void enterUserName(String thisUsername){
        driver.findElement(username).sendKeys(thisUsername);
        logger.info("Username entered");
        Actions a  = new Actions(driver);
    }

    public void enterPassword(String thisPassword){
        driver.findElement(password).sendKeys(thisPassword);
        logger.info("Password entered");
    }

    public ProductsPage clickLoginButton(){
        if(driver.findElement(errorButton).isDisplayed()){
                driver.findElement(errorButton).click();
        }
        driver.findElement(loginButton).click();
        logger.info("Login button clicked");
        ProductsPage theProductsPage = doLogin();
        return new ProductsPage();
    }

    public String getPageTitle(){
        logger.info("Login page titled as: "+driver.getTitle());
        return driver.getTitle();
    }

    public boolean checkErrorMessagePresence(){
        if(driver.findElement(errorButton).isDisplayed()){
            logger.error("Error message present on screen");
            return false;
        }else{
            logger.error("Error message doesn't present on screen");
            return true;
        }
    }
}

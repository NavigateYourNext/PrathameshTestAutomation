package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import com.ezsolutions.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

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
    }

    public void enterPassword(String thisPassword){
        driver.findElement(password).sendKeys(thisPassword);
    }

    public ProductsPage clickLoginButton(){
        if(driver.findElement(errorButton).isDisplayed()){
                driver.findElement(errorButton).click();
        }
        driver.findElement(loginButton).click();
        ProductsPage theProductsPage = doLogin();
        return new ProductsPage();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }







}

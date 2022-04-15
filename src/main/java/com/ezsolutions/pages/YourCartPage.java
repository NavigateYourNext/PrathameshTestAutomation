package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends BaseClass {

    private By checkoutButton = By.xpath("//button[text()='Checkout']");

    public YourCartPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyTheAddedProduct(){
        String productAmount =  driver.findElement(By.xpath("//div[normalize-space()='$"+ProductsPage.getMaximumPrice()+"']")).getText();
        if(productAmount.replace("$","").equals(String.valueOf(ProductsPage.getMaximumPrice())))
            return true;
        else
            return false;
    }

    public YourInformationPage checkoutProduct(){
        driver.findElement(checkoutButton).click();
        return new YourInformationPage();
    }
}

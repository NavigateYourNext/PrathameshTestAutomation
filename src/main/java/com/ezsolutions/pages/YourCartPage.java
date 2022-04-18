package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends BaseClass {

    private static Logger logger = LogManager.getLogger(YourCartPage.class);
    private By checkoutButton = By.xpath("//button[text()='Checkout']");

    public YourCartPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyTheAddedProduct(){
        String productAmount =  driver.findElement(By.xpath("//div[normalize-space()='$"+ProductsPage.getMaximumPrice()+"']")).getText();
        if(productAmount.replace("$","").equals(String.valueOf(ProductsPage.getMaximumPrice()))){
            logger.info("Correct product added in shopping cart");
            return true;
        }else{
            logger.error("Incorrect product added in shopping cart");
            return false;
        }

    }

    public YourInformationPage checkoutProduct(){
        driver.findElement(checkoutButton).click();
        logger.info("Clicked on checkout button");
        return new YourInformationPage();
    }
}

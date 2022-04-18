package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OverViewPage extends BaseClass {

    private static Logger logger = LogManager.getLogger(OverViewPage.class);
    private By finishButton = By.xpath("//button[text()='Finish']");

    public OverViewPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean doCheckoutReview(){
        Double itemPrice = getDoubleValue(driver.findElement(By.xpath("//div[normalize-space()='Item total: $"+ProductsPage.getMaximumPrice()+"']")).getText().trim());
        Double taxPrice = getDoubleValue(driver.findElement(By.xpath("//div[normalize-space()='Tax: $4.00']")).getText().trim());
        Double totalPrice = getDoubleValue(driver.findElement(By.xpath("//div[normalize-space()='Total: $53.99']")).getText().trim());

        logger.info("Item price as: "+itemPrice);
        logger.info("Tax price as: "+taxPrice);
        logger.info("Total price as: "+totalPrice);

        if(totalPrice == (itemPrice+taxPrice)){
            logger.info("Total price displayed correctly");
            return true;
        }
        else{
            logger.error("Total price displayed incorrectly");
            return false;
        }

    }

    public CompletePage clickFinishButton(){
        driver.findElement(finishButton).click();
        logger.info("Finish button clicked");
        return new CompletePage();
    }

    private Double getDoubleValue(String text){
        Pattern pattern = Pattern.compile("[\\d]+.[\\d]+");
        Matcher matcher = pattern.matcher(text);

        String amount="";
        while(matcher.find()){
            amount = matcher.group();
        }
        return Double.parseDouble(amount);
    }
}

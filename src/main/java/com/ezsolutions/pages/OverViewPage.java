package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OverViewPage extends BaseClass {

    private By finishButton = By.xpath("//button[text()='Finish']");

    public OverViewPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean doCheckoutReview(){
        Double itemPrice = getDoubleValue(driver.findElement(By.xpath("//div[normalize-space()='Item total: $"+ProductsPage.getMaximumPrice()+"']")).getText().trim());
        Double taxPrice = getDoubleValue(driver.findElement(By.xpath("//div[normalize-space()='Tax: $4.00']")).getText().trim());
        Double totalPrice = getDoubleValue(driver.findElement(By.xpath("//div[normalize-space()='Total: $53.99']")).getText().trim());

        if(totalPrice == (itemPrice+taxPrice))
            return true;
        else
            return false;
    }

    public CompletePage clickFinishButton(){
        driver.findElement(finishButton).click();
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

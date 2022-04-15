package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompletePage extends BaseClass {

    private By finalMessage = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

    public CompletePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyFinalMessage(){
        String originalMessage = driver.findElement(finalMessage).getText();
        return originalMessage;
    }
}

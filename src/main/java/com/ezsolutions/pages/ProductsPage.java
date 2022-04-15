package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseClass {

    private By productPageText = By.xpath("//span[text()='Products']");

    public ProductsPage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        return driver.findElement(productPageText).getText();
    }

}

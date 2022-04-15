package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BaseClass {

    private By productPageText = By.xpath("//span[text()='Products']");
    private static By pricePath = By.xpath("//div[@class='inventory_item_price']");
    private By shoppingCartLink = By.xpath("//a[@class='shopping_cart_link']");

    public ProductsPage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        return driver.findElement(productPageText).getText();
    }

    public void selectMaximumPriceProduct(){
        driver.findElement(By.xpath("//div[normalize-space()='$"+getMaximumPrice()+"']/following-sibling::button")).click();

    }

    public YourCartPage goToShoppingCart(){
        driver.findElement(shoppingCartLink).click();
        return new YourCartPage();
    }

    public static Double getMaximumPrice(){
        List<WebElement> priceList = driver.findElements(pricePath);
        double maximumPrice =  priceList
                .stream()
                .mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$","")))
                .max()
                .getAsDouble();
        return maximumPrice;
    }
}

package com.ezsolutions.utilities;

import com.ezsolutions.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

    public static void setText(WebElement element, String text){
      element.sendKeys(text);
    }

    public static void clickButton(WebElement element){
        element.click();
    }

}

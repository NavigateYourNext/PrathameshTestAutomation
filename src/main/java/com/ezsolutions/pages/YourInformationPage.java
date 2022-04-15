package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage extends BaseClass {

    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By zipCodeField = By.name("postalCode");
    private By continueButton = By.name("continue");

    public YourInformationPage(){
        PageFactory.initElements(driver,this);
    }

    public OverViewPage enterUserPersonalDetails(String firstName, String lastName, String postalCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();

        return new OverViewPage();
    }
}

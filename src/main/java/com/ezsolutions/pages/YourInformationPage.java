package com.ezsolutions.pages;

import com.ezsolutions.base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage extends BaseClass {

    private static Logger logger = LogManager.getLogger(YourInformationPage.class);
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By zipCodeField = By.name("postalCode");
    private By continueButton = By.name("continue");

    public YourInformationPage(){
        PageFactory.initElements(driver,this);
    }

    public OverViewPage enterUserPersonalDetails(String firstName, String lastName, String postalCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        logger.info("First name entered");
        driver.findElement(lastNameField).sendKeys(lastName);
        logger.info("Last name entered");
        driver.findElement(zipCodeField).sendKeys(postalCode);
        logger.info("Zipcode entered");
        driver.findElement(continueButton).click();
        logger.info("Clicked on continue button");

        return new OverViewPage();
    }
}

package com.ezsolutions.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.AfterTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/TestSauceDemo.feature"}
        ,glue={"com.ezsolutions.stepdefinition"}
        ,plugin = {"pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
}
        //tags="@Functional"
)
public class TestRunner{

}
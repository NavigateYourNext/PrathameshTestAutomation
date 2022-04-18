package com.ezsolutions.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/TestSauceDemo.feature"}
        ,glue={"com.ezsolutions.stepdefinition","com.ezsolutions.hooks"}
        ,plugin = {"pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
}//,
        //tags="@Sanity1"
)
public class TestRunner{

}
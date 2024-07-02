package com.ust.orangehrm;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"C:\\Users\\271501\\eclipse-workspace\\orangehrm\\src\\test\\java\\com\\ust\\orangehrm"},
		glue = {"com.ust.orangehrm"},
		plugin= {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread",
				"html:Reports/cucumber-reports/index.html"}
			
		)

public class CucumberRunner extends AbstractTestNGCucumberTests {
	

}

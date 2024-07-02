package com.ust.nopcommercebdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {
				"C:\\Users\\271501\\eclipse-workspace\\nopcommercebdd\\src\\test\\java\\com\\ust\\nopcommercebdd\\login.feature",
				"C:\\Users\\271501\\eclipse-workspace\\nopcommercebdd\\src\\test\\java\\com\\ust\\nopcommercebdd\\search.feature"
				},
		glue = {"com.ust.nopcommercebdd"},
		plugin= {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread",
				"html:Reports/cucumber-reports/index.html"}
		//tags= {"@SmokeTest,@RegressionTest"}	
		)

public class CucumberRunner extends AbstractTestNGCucumberTests{

}
package com.selenium.runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(tags = "@tag1",features = {"src/test/resources/features/*.feature"},glue= {"com.selenium.stepdef"})
public class TestRunner extends AbstractTestNGCucumberTests {

}

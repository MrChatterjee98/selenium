package com.selenium.stepdef;



import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class TestDemo {

	private static WebDriver chromeDriver;
	private String pacakgeName = "com.selenium.xpaths";
	Actions actions;

	@Before
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\biswa\\Selenium\\selenium-demo\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("-private");
		chromeDriver = new ChromeDriver(options);
		actions = new Actions(chromeDriver);
	}

	private String getXpathFromElement(String element, String page) throws Exception {
		page = this.pacakgeName + "." + page;
		Class<?> c = Class.forName(page);
		Object o = c.getConstructor().newInstance(null);
		String s = (String) c.getMethod(element, null).invoke(o, null);
		return s;
	}
	
	@Given("the user opens the {string} page")
	public void openPage(String s) throws InterruptedException {
		chromeDriver.get(s);
		chromeDriver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@And("the user hovers over the {string} element at {string} page")
	public void hover(String element, String page) throws Exception  {
		WebElement element2 =chromeDriver.findElement(By.xpath(this.getXpathFromElement(element, page)));
		if(element2.isDisplayed())
			actions.moveToElement(element2);
	}
	@And("the user clicks the {string} element at {string} page")
	public void click(String element, String page) throws Exception {
			WebElement element2 =chromeDriver.findElement(By.xpath(this.getXpathFromElement(element, page)));
			if(element2.isDisplayed())
				element2.click();
	}
	@And("the user enters {string} into the {string} textbox at {string} page")
	public void enterInput(String value,String element,String page) throws Exception{
		WebElement element2 =chromeDriver.findElement(By.xpath(this.getXpathFromElement(element, page)));
			actions.click(element2);
			element2.sendKeys(value);
		
	}
	@And("the user hits enter")
	public void enter() {
		actions.sendKeys(Keys.ENTER);
	}
	@And("the user waits for {string} seconds")
	public void wait(String s) throws InterruptedException {
		long i = Long.parseLong(s);
		Thread.sleep(i*1000);
	}
	@After
	public void cleanUp() {
		chromeDriver.close();
	}
}

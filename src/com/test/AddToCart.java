package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

class AddToCart {

	static boolean bool = true;
	
	public static void addToCart() throws InterruptedException {		

		// System Property for Chrome Driver   
	    System.setProperty("webdriver.chrome.driver","chromedriver_94.exe");  
	      
	    // Instantiate a ChromeDriver class.       
	    WebDriver d=new ChromeDriver();  
	    d.manage().window().maximize();
	    
		
		d.get("https://www.amazon.in/");
				
		d.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		d.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
//		Thread.sleep(3000);
		WebElement prod_item1 = d.findElement(By.xpath("(//h2//a)[1]"));
		((JavascriptExecutor)d).executeScript("arguments[0].removeAttribute('target')", prod_item1);
		Thread.sleep(3000);
		String expectedText = d.findElement(By.xpath("(//h2//a/span)[1]")).getText();
		prod_item1.click();
		Thread.sleep(3000);
		d.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
//		d.findElement(By.className("a-button-input")).click();
//		Thread.sleep(3000);
		d.findElement(By.xpath("(//a[contains(text(),'Cart')])[1]")).click();
		Thread.sleep(3000);
		
		String actualText = d.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
		Reporter.log(actualText,bool);
		Assert.assertEquals(expectedText, actualText);
	
		
		
		
	}

	
	@Test
	public void testAddToCart() throws InterruptedException {
	
		AddToCart.addToCart();
		
	}
	
	
}
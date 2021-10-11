package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AddToCart {

	
	public static void main(String[] args) throws InterruptedException {
		
		// System Property for Chrome Driver   
	    System.setProperty("webdriver.chrome.driver","chromedriver_94.exe");  
	      
	    // Instantiate a ChromeDriver class.       
	    WebDriver d=new ChromeDriver();  
	    d.manage().window().maximize();
	    
		
		d.get("https://www.amazon.in/");
				
		d.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		d.findElement(By.id("nav-search-submit-button")).click();
		
//		Thread.sleep(3000);
		WebElement prod_item1 = d.findElement(By.xpath("(//h2//a)[1]"));
		((JavascriptExecutor)d).executeScript("arguments[0].removeAttribute('target')", prod_item1);
		
		prod_item1.click();
		d.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		d.findElement(By.className("a-button-input")).click();
		d.findElement(By.id("hlb-view-cart")).click();
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
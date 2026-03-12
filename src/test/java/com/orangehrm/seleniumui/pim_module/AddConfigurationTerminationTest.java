package com.orangehrm.seleniumui.pim_module;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddConfigurationTerminationTest {
	WebDriver driver = new EdgeDriver();
	String terminationReasonName = "IronMan Reason";
	
	@Test(priority = 1)
	public void login() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Filling credentials
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
	}
	
	@Test(priority = 2)
	public void performAction() {
		driver.findElement(By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]")).click();
		
		driver.findElement(By.xpath("//li/span[contains(., 'Configuration')]")).click();
		
		driver.findElement(By.xpath("//li/a[contains(., 'Termination Reasons')]")).click();
		
		// clicking add button
		driver.findElement(By.xpath("//button[contains(., \"Add\")]")).click();
		
		//filling details
		driver.findElement(By.xpath("//label/../..//input")).sendKeys(terminationReasonName);
		
		// save
		driver.findElement(By.xpath("//button[contains(., \"Save\")]")).click();
		
		
	}
	
	@Test(priority = 3)
	public void verifyAddedData() {
		
		// explicit wait to be added
		
		// verify user
		WebElement searchResult = driver.findElement(By.xpath("//div[contains(text(), \"" + terminationReasonName + "\")]"));
		
		System.out.println(searchResult.getText() + " : " + searchResult.getTagName());
		
		if(searchResult.isDisplayed()) {
			System.out.println("Data Added and verified successfully");
		}else {
			System.out.println("Failed verificaiton");
		}
		
	}
	
	@Test(priority = 10)
	public void logOutOrangeHRM(){

		driver.findElement(By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]")).click();
		
		driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]")).click();	
		
	}
}

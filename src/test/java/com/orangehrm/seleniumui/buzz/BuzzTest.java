package com.orangehrm.seleniumui.buzz;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BuzzTest {

	WebDriver driver;
	WebDriverWait wait;

	@Test(priority = 1)
	public void login() {
		driver = new EdgeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().window().maximize();

		// Filling credentials
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

	}

	@Test(priority = 2, dependsOnMethods = "login")
	public void performAction() {
		driver.findElement(By.xpath("//a[@href=\"/web/index.php/buzz/viewBuzz\"]")).click();
		
		String messageToAdd = "Hello from IronMan";
		driver.findElement(By.tagName("textarea")).sendKeys(messageToAdd);
		
		driver.findElement(By.xpath("//button[contains(., 'Post')]")).click();
		
		driver.navigate().refresh();
		
		WebElement res = driver.findElement(By.xpath("//p[.='" + messageToAdd + "']"));	
		
		if(res.isDisplayed() && res.getText().equals(messageToAdd)) {
			System.out.println("Verified successfully");
		}else {
			System.out.println("Failed verification");
		}
	}


	@Test(priority = 10)
	public void logOutOrangeHRM() {

//		driver.findElement(By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]")).click();
//
//		driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]")).click();

	}
}

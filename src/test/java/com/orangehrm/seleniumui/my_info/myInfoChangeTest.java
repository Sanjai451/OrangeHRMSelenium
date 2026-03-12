package com.orangehrm.seleniumui.my_info;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class myInfoChangeTest {
	WebDriver driver;
	WebDriverWait wait;

	@Test(priority = 1)
	public void login() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver = new FirefoxDriver();
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
		driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']")).click();

//		System.out.println("Inside perform actions");
		
		System.out.println("prev : " + driver.findElement(By.xpath("//input[@name='firstName']")).getText());
		
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		try {
			Thread.sleep(1000);
			firstName.sendKeys(Keys.CONTROL + "a");
			firstName.sendKeys(Keys.BACK_SPACE);
		} catch (Exception e) {
		}
		firstName.sendKeys("Spiderman");
		
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		try {
			Thread.sleep(1000);
			lastName.sendKeys(Keys.CONTROL + "a");
			lastName.sendKeys(Keys.BACK_SPACE);
		} catch (Exception e) {
		}
		lastName.sendKeys("S");
		
		WebElement empID = driver.findElement(By.xpath("//label[text()='Employee Id']/../..//input"));
		try {
			Thread.sleep(1000);
			empID.sendKeys(Keys.CONTROL + "a");
			empID.sendKeys(Keys.BACK_SPACE);
		} catch (Exception e) {
		}
		empID.sendKeys("spider@123");

//		driver.findElement(By.xpath("//button[contains(., 'Save')]"));
//		
//		try {
//			Thread.sleep(4000);
//		} catch (Exception e) {
//		}
//		WebElement vIcon = driver.findElement(By.xpath("//label[.='Employee Full Name']"));
		
//		if(vIcon.isDisplayed()) {
//			System.out.println("Saved and loaded");
//		}else {
//			System.out.println("Failed after pressing save button");
//		}
//		try {
//			Thread.sleep(4000);
//		} catch (Exception e) {
//		}
//
//
////		// logout
//		driver.findElement(By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]")).click();
//
//		driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]")).click();
//
////		// Again Login
//		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
//
//		driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']")).click();

		System.out.println("after : " + driver.findElement(By.xpath("//input[@name='firstName']")).getText());
		
	}


	@Test(priority = 10)
	public void logOutOrangeHRM() {

//		driver.findElement(By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]")).click();
//
//		driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]")).click();

	}
}

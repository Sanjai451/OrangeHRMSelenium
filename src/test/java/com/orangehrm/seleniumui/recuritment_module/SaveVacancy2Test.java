package com.orangehrm.seleniumui.recuritment_module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SaveVacancy2Test {
	WebDriver driver = new EdgeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
		driver.findElement(By.xpath("//a[@href=\"/web/index.php/recruitment/viewRecruitmentModule\"]")).click();

		driver.findElement(By.xpath("//a[text()='Vacancies']")).click();

//		// 1st input
//
//		WebElement jobTitle = driver.findElement(By.xpath("//label[text()=\"Job Title\"]/../../div[2]/div/div/div"));
//
//		jobTitle.click();
//
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//
//		jobTitle.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//
//		// 2st input
//
//		WebElement vacancy = driver.findElement(By.xpath("//label[text()=\"Vacancy\"]/../../div[2]/div/div/div"));
//
//		vacancy.click();
//
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//
//		vacancy.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//
//		// 3rd input
//
//
//		WebElement hm = driver.findElement(By.xpath("//label[text()=\"Hiring Manager\"]/../../div[2]/div/div/div"));
//
//		hm.click();
//
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//
//		hm.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		
//		// 4th input
//		
//		WebElement status = driver.findElement(By.xpath("//label[text()=\"Status\"]/../../div[2]/div/div/div"));
//
//		status.click();
//
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//
//		status.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		
		helper("Job Title", 3);
		helper("Vacancy", 1);
		helper("Hiring Manager", 2);
		helper("Status", 2);
		
		

	}
	
	public void helper(String labelName, int option) {
		WebElement input = driver.findElement(By.xpath("//label[text()=\"" + labelName + "\"]/../../div[2]/div/div/div"));

		input.click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		
		for(int i=0; i<option; i++) {
			input.sendKeys(Keys.ARROW_DOWN);
		}

		input.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
		
		
	}

	@Test(priority = 10)
	public void logOutOrangeHRM() {

		driver.findElement(By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]")).click();

		driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]")).click();
		
		driver.quit();

	}
}

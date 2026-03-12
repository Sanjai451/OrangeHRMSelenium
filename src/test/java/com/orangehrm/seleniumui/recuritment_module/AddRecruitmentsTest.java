package com.orangehrm.seleniumui.recuritment_module;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddRecruitmentsTest {
	WebDriver driver = new EdgeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	String firstName = "ironman";
	String middleName = "batman";
	String lastName = "S";
	String name = firstName + " " + middleName + " " + lastName;
	
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

		driver.findElement(By.xpath("//button[contains(., 'Add')]")).click();
		
		// firstname
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("middleName")).sendKeys(middleName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		
		WebElement vac = driver.findElement(By.xpath("//label[text()=\"Vacancy\"]/../../div[2]/div/div/div"));
		
		vac.click();
		vac.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		
		driver.findElement(By.xpath("//label[.='Email']/../..//input")).sendKeys("sanjai6369kumar@gmail.com");
		
		driver.findElement(By.xpath("//label[.='Contact Number']/../..//input")).sendKeys("9090908989");
		
		String filePath = "C:\\Users\\Admin\\Downloads\\AI Interviewer - Automated Candidate Evaluation using LLM.pdf";
		
		driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys(filePath);
		
		WebElement dateInput = driver.findElement(By.xpath("//input[@placeholder=\"yyyy-dd-mm\"]"));
		dateInput.sendKeys(Keys.CONTROL + "a");
		dateInput.sendKeys(Keys.BACK_SPACE);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		dateInput.sendKeys("2025-11-11");
		
		driver.findElement(By.xpath("//button[contains(., 'Save')]")).click();
		
		WebElement disp = driver.findElement(By.xpath("//h6[.='Candidate Profile']"));
		
		
//		try {
//			Thread.sleep(12000);
//		} catch (Exception e) {
//		}

	}
	
	@Test(priority = 3)
	public void verify() {
		driver.findElement(By.xpath("//a[.='Candidates']")).click();
		
		driver.findElement(By.xpath("//label[text()='Candidate Name']/../..//input"))
			.sendKeys(firstName);
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		
		driver.findElement(By.xpath("//label[text()='Candidate Name']/../..//input"))
			.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		
		driver.findElement(By.xpath("//button[contains(., 'Search')]")).click();

		WebElement result = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border\"]//div[contains(., '" + firstName + "')]")
						)
				);
		if(result.isDisplayed()) {
			System.out.println(result.getText() + " SUCCESSFULLY DISPLAYED");
		}else {
			System.out.println("Failed to display");
		}
	}


	@Test(priority = 10)
	public void logOutOrangeHRM() {

		driver.findElement(By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]")).click();

		driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]")).click();

	}
}

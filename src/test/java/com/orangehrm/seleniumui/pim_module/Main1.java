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

public class Main1 {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Filling credentials
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']")).click();

		System.out.println("Inside perform actions");
		
		System.out.println(driver.findElement(By.xpath("//input[@name='firstName']")).getText());
		System.out.println(driver.findElement(By.xpath("//input[@name='firstName']")).getText());
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Spiderman");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("S");
		
		System.out.println("Changed Values");
		
		driver.findElement(By.xpath("//label[text()='Employee Id']/../..//input")).sendKeys("spider@123");

		driver.findElement(By.xpath("//button[contains(., 'Save')]"));
	}
}

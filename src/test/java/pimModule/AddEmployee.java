package pimModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddEmployee {
	WebDriver driver = new EdgeDriver();
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
	public void perform1() {
		driver.findElement(By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]")).click();
		
		// clicking add button
		driver.findElement(By.xpath("//button[contains(., \"Add\")]")).click();
		
		//filling details
		driver.findElement(By.name("firstName")).sendKeys("Sanjai");
		driver.findElement(By.name("middleName")).sendKeys("Kumar");
		driver.findElement(By.name("lastName")).sendKeys("R");
		
//		driver.findElement(By.cssSelector("[type=\"checkbox\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement toggle = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//span[contains(@class,'oxd-switch-input')]")
		        ));

		toggle.click();
		
		driver.findElement(By.xpath("//label[text()=\"Username\"]/../..//input")).sendKeys("spiderman");
		driver.findElement(By.xpath("//label[text()=\"Password\"]/../..//input")).sendKeys("123456abcd");
		driver.findElement(By.xpath("//label[text()=\"Confirm Password\"]/../..//input")).sendKeys("123456abcd");
		
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		
		
	}
	
	@Test(priority = 3)
	public void verifyAddedData() {
		driver.findElement(By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]")).click();
		driver.findElement(By.xpath("//label[text()=\"Username\"]/../..//input")).sendKeys("spiderman");
		
		//selecting ESS Role
//		WebElement role = driver.findElement(By.xpath("//label[text()=\"User Role\"]/../..//i"));
		WebElement role = driver.findElement(By.xpath("//label[text()=\"User Role\"]/../../div[2]/div/div/div"));
		
		role.click();
		role.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		
		driver.findElement(By.xpath("//button[contains(., 'Search')]")).click();
		
		// verify user
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"]"));
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(searchResults);
		if(searchResults.size() >= 1) {
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

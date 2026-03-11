package recuritmentModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SaveVacancies {
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
		
		driver.findElement(By.xpath("//button[contains(., 'Add')]")).click();
		
		driver.findElement(By.xpath("//label[text()=\"Vacancy Name\"]/../..//input"))
				.sendKeys("SDE");

		WebElement jobTitle = driver.findElement(By.xpath("//label[text()=\"Job Title\"]/../../div[2]/div/div/div"));

		jobTitle.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		
		jobTitle.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);


		driver.findElement(By.tagName("textarea")).sendKeys("Freshers role");
		
		driver.findElement(By.xpath("//label[text()=\"Hiring Manager\"]/../..//input"))
				.sendKeys("AB");
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		
		driver.findElement(By.xpath("//label[text()=\"Hiring Manager\"]/../..//input"))
			.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		
		driver.findElement(By.xpath("//label[text()=\"Number of Positions\"]/../..//input"))
				.sendKeys("3");
		
		driver.findElement(By.xpath("//button[contains(., 'Save')]")).click();

	}


	@Test(priority = 10)
	public void logOutOrangeHRM() {

		driver.findElement(By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]")).click();

		driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]")).click();

	}
}

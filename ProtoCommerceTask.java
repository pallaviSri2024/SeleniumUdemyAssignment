import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProtoCommerceTask {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void registrationForm() {
		
		WebElement name = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("name")));
		name.sendKeys("Pallavi Srivastava");
		
		WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("name")));
		email.sendKeys("palrit2019@gmail.com");
		
		WebElement password = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("exampleInputPassword1")));
		password.sendKeys("Password@123");
		
		WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("exampleCheck1")));
				checkbox.click();
		
		WebElement genderDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleFormControlSelect1")));
		Select select =new Select(genderDropDown);
		select.selectByVisibleText("Female");
		
		WebElement radio = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("inlineRadio1")));
		radio.click();
		
		WebElement Calendar = wait.until(ExpectedConditions.elementToBeClickable(By.name("bday")));
		Calendar.sendKeys("18-02-2026");
		
		 WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='btn btn-success']")));
		 submit.click();
		
		 WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
		 

	        Assert.assertTrue(successMsg.getText().contains("Success"));
	        System.out.println("Form submitted successfully!.");
		
		
	}
	
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
	
	
}

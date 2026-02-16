import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxTest {
	
WebDriver driver;
	
	@BeforeMethod
    public void setup() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void verifyCheckboxSelection() {

        WebElement firstCheckbox = driver.findElement(By.id("checkBoxOption1"));

        // Check checkbox
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), "Checkbox not selected");

        // Uncheck checkbox
        firstCheckbox.click();
        Assert.assertFalse(firstCheckbox.isSelected(), "Checkbox not unselected");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

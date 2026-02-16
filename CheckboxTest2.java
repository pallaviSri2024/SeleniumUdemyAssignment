import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest2 {

	WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void verifyCheckboxSelectionAndCount() {

        // 🔹 Get count of all checkboxes on page
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int checkboxCount = checkboxes.size();

        System.out.println("Total number of checkboxes: " + checkboxCount);

        // 🔹 Verify count is greater than 0
        Assert.assertTrue(checkboxCount > 0, "No checkboxes found on page");

        // 🔹 Select first checkbox
        WebElement firstCheckbox = checkboxes.get(0);
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), "Checkbox not selected");

        // 🔹 Unselect first checkbox
        firstCheckbox.click();
        Assert.assertFalse(firstCheckbox.isSelected(), "Checkbox not unselected");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

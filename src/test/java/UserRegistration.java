import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Alena on 25.10.2016.
 */


public class UserRegistration {

    @Test
    public void createNewAccount() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alena\\geckodriver-v0.11.1-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com");
        sleep(3000);

        // #1 test blank fields registration
        driver.findElement(By.id("reg-firstname")).clear();
        driver.findElement(By.id("reg-firstname")).sendKeys("");

        driver.findElement(By.id("reg-lastname")).clear();
        driver.findElement(By.id("reg-lastname")).sendKeys("");

        driver.findElement(By.id("reg-email")).clear();
        driver.findElement(By.id("reg-email")).sendKeys("");

        driver.findElement(By.id("reg-password")).clear();
        driver.findElement(By.id("reg-password")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='Join now']")).click();

        sleep(3000);

        String actualError = driver.findElement(By.xpath("//div[contains(@class, 'reg-alert')]/span[@class='alert-content' and text()]")).getText();
        String expectedError = "Please enter your first name";

        Assert.assertEquals(actualError, expectedError);
        System.out.println((char)27 + "[32m#1 test successfully passed (blank fields registration)");
//      Assert.assertTrue(actualError.contains("Please enter your first name"));

        // #2 invalid email registration
        driver.findElement(By.xpath("//button[contains(@class, 'dismiss-alert')]")).click();
        sleep(3000);

        driver.findElement(By.id("reg-firstname")).clear();
        driver.findElement(By.id("reg-firstname")).sendKeys("John");
        driver.findElement(By.id("reg-lastname")).clear();
        driver.findElement(By.id("reg-lastname")).sendKeys("Smith");

        driver.findElement(By.id("reg-email")).clear();
        driver.findElement(By.id("reg-email")).sendKeys("a@gmail");
        driver.findElement(By.id("reg-password")).clear();
        driver.findElement(By.id("reg-password")).sendKeys("123456A");
        driver.findElement(By.xpath("//input[@value='Join now']")).click();

        String actualError2 = driver.findElement(By.xpath("//div[contains(@class, 'reg-alert')]/span[@class='alert-content' and text()]")).getText();
        String expectedError2 = "Please enter a valid email address";

        Assert.assertEquals(actualError2, expectedError2);
        System.out.println((char)27 + "[32m#2 test successfully passed (invalid email registration)");

    }

}



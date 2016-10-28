import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Alena on 22.10.2016.
 */
public class Cheescakes {

    @Test
    public void listCheesecakes() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alena\\geckodriver-v0.11.1-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.thecheesecakefactory.com");

        driver.findElement(By.id("closeBtn")).click();
        sleep(3000);

        driver.findElement(By.xpath("//a[@href='/menu/']")).click();
        sleep(3000);

        driver.findElement(By.xpath("//a[@href='/menu/desserts/']")).click();
        sleep(3000);

        driver.findElement(By.xpath("//a[@href='/menu/desserts/cheesecakes/']")).click();
        sleep(3000);


        List<WebElement> cheesecakes = driver.findElements(By.xpath("//a[contains(@href, '/menu/desserts/cheesecakes/')]/span[@class='item-title' and text()]"));


        System.out.println(cheesecakes.size() + " cheesecakes:");

        for (int i=0; i<cheesecakes.size(); i++) {

            System.out.println(i+1 + ". " + cheesecakes.get(i).getText());

        }

    }


}

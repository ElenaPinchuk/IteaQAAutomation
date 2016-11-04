
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Alena on 30.10.2016.
 */
public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }



    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alena\\geckodriver-v0.11.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }




 @AfterClass
  public void tearDown() {
driver.quit();
  }

}
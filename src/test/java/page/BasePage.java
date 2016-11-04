package page;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToBaseUrl () {
        driver.get("https://www.linkedin.com/");
    }

}




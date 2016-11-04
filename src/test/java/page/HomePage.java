package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static java.lang.Thread.sleep;

public class HomePage extends BasePage{

    private WebElement homeMenuLink;


    public HomePage(WebDriver driver) {

        super(driver);
    }


    public void initElements() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homeMenuLink = driver.findElement(By.xpath("//div[@id='main-site-nav']//a[@class='nav-link' and @href='/home?trk=nav_responsive_tab_home']"));
    }

    public boolean isPageLoaded() {
        return homeMenuLink.isDisplayed();
    }

}
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


/**
 * Created by Alena on 31.10.2016.
 */
public class SearchPage extends BasePage  {

    private WebElement advancedSearchLink;

    private WebElement keywordField;
    private WebElement searchButton;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickAdvancedLink() {
        advancedSearchLink.click();
    }

    public boolean isPageLoaded() {
       return advancedSearchLink.isDisplayed();
    }


    public void enterSearchTermAndSubmit(String searchTerm) {
        keywordField.clear();
        keywordField.sendKeys(searchTerm);
        searchButton.click();
    }


  //  WebElement firstItemTitleElement=driver.findElement(By.classNamee("s-access-title"));
  //  String firstItemTitle = firstItemTitleElement.getText();
//	        firstItemTitleElement.click();




   //String result = driver.findElement(By.id("s-result-count")).getText().split(" ")[2];
  //  int result = driver.findElements(By.xpath(".//*[@id='atfResults']/ul[@id='s-results-list-atf']/li")).size();
   //     assertEquals(10, result.size());

    public int acceptSearchResult() {
       int resultOnPage = driver.findElements(By.tagName("b")).size();
        return resultOnPage;
    }

    public String verifySearchTerm() {
        WebElement searchTerm = driver.findElement(By.xpath("//*[contains(text(), 'HR')]"));
        return searchTerm.getText();
    }


        //   searchResultList.get(id).findElements(By.tagName("b"));
        //   for (int i = 0; i < searchResultList.size(); i++) {

        //        System.out.println(i + 1 + ". " + searchResultList.get(i).getText());
        //    }
        //  }


        public void initElements () {

            advancedSearchLink = driver.findElement(By.id("advanced-search"));

            keywordField = driver.findElement(By.xpath("//div[contains(@class, 'form-controls')]/input[@class='submit-advs']"));
            searchButton = driver.findElement(By.className("submit"));
        }
    }

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;




/**
 * Created by Alena on 02.11.2016.
 */
public class SearchTests extends BaseTest {

    @Test

    public void advancedLinkClickAndSearchTermSubmit() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.navigateToBaseUrl();
        registrationPage.initElements();
        registrationPage.loginFormFillAndSubmit("selena1388@mail.ru","123654A");
        HomePage homePage = new HomePage(getDriver());
        homePage.initElements();
        Assert.assertTrue(homePage.isPageLoaded());
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.initElements();
        searchPage.clickAdvancedLink();
        Assert.assertTrue(searchPage.isPageLoaded());
        searchPage.enterSearchTermAndSubmit("HR");
        Assert.assertEquals(10, searchPage.acceptSearchResult());
        Assert.assertEquals("HR", searchPage.verifySearchTerm(), "Expected list was not found on page");
    }
   }


 //











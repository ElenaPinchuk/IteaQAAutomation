import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;


/**
 * Created by Alena on 29.10.2016.
 */

public class LoginRegistrationTests extends BaseTest{

    @Test
    public void errorMessageOnEmptyFormSubmit() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.navigateToBaseUrl();
        registrationPage.initElements();
        registrationPage.registrationFormFillAndSubmit("","","","");
        Assert.assertEquals(registrationPage.getErrorMessageText(), "Please enter your first name", "Expected error message was not found on page");
    }

    @Test
    public void successfulLoginTest() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.navigateToBaseUrl();
        registrationPage.initElements();
        registrationPage.loginFormFillAndSubmit("selena1388@mail.ru","123654A");
        HomePage homePage = new HomePage(getDriver());
        homePage.initElements();
        Assert.assertTrue(homePage.isPageLoaded());
       // SearchPage searchPage = new SearchPage(getDriver());
       // searchPage.initElements();
      //  Assert.assertTrue(searchPage.isPageLoaded());
    }
}

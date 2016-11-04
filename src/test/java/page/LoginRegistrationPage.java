package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginRegistrationPage extends BasePage {

    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement joinNowButton;
    private WebElement errorMessageBox;

    private WebElement loginEmailField;
    private WebElement loginPasswordField;
    private WebElement signInButton;

    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void loginFormFillAndSubmit(String loginEmail, String loginPassword) {
        loginEmailField.sendKeys(loginEmail);
        loginPasswordField.sendKeys(loginPassword);
        signInButton.click();
    }

    public void registrationFormFillAndSubmit(String firstName, String lastName, String email, String password ) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        joinNowButton.click();
    }

    public void initElements () {
        firstNameField = driver.findElement(By.id("reg-firstname"));
        lastNameField = driver.findElement(By.id("reg-lastname"));
        emailField = driver.findElement(By.id("reg-email"));
        passwordField = driver.findElement(By.id("reg-password"));
        joinNowButton = driver.findElement(By.id("registration-submit"));

        loginEmailField = driver.findElement(By.id("login-email"));
        loginPasswordField = driver.findElement(By.id("login-password"));
        signInButton = driver.findElement(By.id("login-submit"));
    }

    public String getErrorMessageText() {
        errorMessageBox = driver.findElement(By.className("alert-content"));
        return errorMessageBox.getText();
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends PageObject {

    private final String EMAIL = "ozaneseriu@gmail.com";
    private final String PASSWORD = "O123.";
    private final String INCORRECTPASSWORD = "O12345.";
    private final String INVALIDEMAIL = "ozaneseriu";
    private final String INVALIDPASSWORD = "12";

    @FindBy(id = "EmailLogin")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg pull-right login__btn js-login-button']")
    private WebElement loginButton;

    @FindBy (xpath = "//div[@class='modal-body']")
    private  WebElement popUpModal;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    private  WebElement popUpOkButton;

    @FindBy (id = "EmailLogin-error")
    private WebElement emailError;

    @FindBy (id = "Password-error")
    private WebElement passwordError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(){
        this.email.clear();
        this.email.sendKeys(EMAIL);
    }

    public void enterPassword(){
        this.password.clear();
        this.password.sendKeys(PASSWORD);
    }

    public void enterIncorrectPassword () {
        this.password.clear();
        this.password.sendKeys(INCORRECTPASSWORD);
    }

    public void enterInvalidEmail () {
        this.email.clear();
        this.email.sendKeys(INVALIDEMAIL);
    }

    public void enterInvalidPassword () {
        this.password.clear();
        this.password.sendKeys(INVALIDPASSWORD);
    }

    public void pressLoginButton(){
        this.loginButton.click();
    }

    // Verify pop-up message. "E-mail address or password is incorrect. Please check your information and try again."
    public void verifyAndClosePopUp() throws InterruptedException {
        Thread.sleep(2000);
        this.popUpModal.isDisplayed();
        this.popUpOkButton.click();
    }

    // Empty Email: Verify the error message displayed under the email input. "Required field."
    public void checkEmailRequiredFieldError() {
        this.emailError.isDisplayed();
        String emptyEmailText = emailError.getText();
        Assert.assertEquals("Required field.", emptyEmailText);
    }

    // Empty Password: Verify the error message displayed under the password input. "Required field."
    public void checkPasswordRequiredFieldError() {
        this.passwordError.isDisplayed();
        String emptyPasswordText = passwordError.getText();
        Assert.assertEquals("Required field.", emptyPasswordText);
    }

    // Invalid Email: Verify the error message displayed under the email input. "Please enter a valid e-mail address."
    public void checkInvalidEmailField () {
        this.emailError.isDisplayed();
        String invalidEmailText = emailError.getText();
        Assert.assertEquals("Please enter a valid e-mail address.", invalidEmailText);
    }

    // Invalid Password: Verify the error message displayed under the password input. "Please enter minimum 3 and maximum 20 characters."
    public void checkInvalidPasswordField() {
        this.passwordError.isDisplayed();
        String invalidPasswordText = passwordError.getText();
        Assert.assertEquals("Please enter minimum 3 and maximum 20 characters.", invalidPasswordText);
    }
}
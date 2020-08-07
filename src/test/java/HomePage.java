import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class HomePage extends PageObject {

    @FindBy(xpath = "//div[@class='header__right-col']//span[@class='user-menu__title'][contains(text(),'My Account')]")
    private WebElement textMyAccount;

    @FindBy (xpath = "//a[@class='user-menu__log-out']")
    private WebElement logoutIcon;

    @FindBy (xpath = "//div[@class='subheader-close js-subheader-close is-hidden']")
    private WebElement closePopup;

    public HomePage (WebDriver driver) {
        super(driver);
    }

    /*
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
     */

    // Verify if the user successfully logged in
    public void checkUserAccountText() {
        try {
            //Thread.sleep(4000);
            String text = textMyAccount.getText();
            Assert.assertEquals("My Account", text);
        } catch (NoSuchElementException ignored) {

        }
    }

    //Verify Logout Button "X"
    public void checkLogoutButton() {
        try {
            this.closePopup.click();
            this.logoutIcon.isDisplayed();
            this.logoutIcon.click();
        } catch (NoSuchElementException ignored) {

        }
    }

}
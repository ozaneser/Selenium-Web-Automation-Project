import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void setup() {
        //ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        //Maximizes the browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test(priority = 4,testName = "Sign-In Successfully")
    public static void signInSuccessfully () {
        driver.get(Utils.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.pressLoginButton();
        homePage.checkLogoutButton();
        homePage.checkUserAccountText();
    }

    @Test(priority = 3,testName = "Sign-In with Incorrect Password")
    public static void signInWithIncorrectPassword () throws InterruptedException {
        driver.get(Utils.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail();
        loginPage.enterIncorrectPassword();
        loginPage.pressLoginButton();
        loginPage.verifyAndClosePopUp();
    }

    @Test(priority = 2,testName = "Sign-in with Empty Email and Empty Password")
    public static void signInWithEmptyEmailPassword () {
        driver.get(Utils.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.pressLoginButton();
        loginPage.checkEmailRequiredFieldError();
        loginPage.checkPasswordRequiredFieldError();
    }

    @Test(priority = 1,testName = "Sign-In with Invalid Email and Password")
    public static void signInWithInvalidEmailPassword () {
        driver.get(Utils.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInvalidEmail();
        loginPage.enterInvalidPassword();
        loginPage.pressLoginButton();
        loginPage.checkInvalidEmailField();
        loginPage.checkInvalidPasswordField();
    }

    @AfterSuite
    public static void cleanUp () {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
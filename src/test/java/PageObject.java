// All Test Pages are inheriting from this class

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {
    protected WebDriver driver;

    public WebDriverWait wait;


    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
    public PageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
     */
}

/*PageFactory allows us to create test pages with the same mechanism behind it.
This way, we don’t need to write WebDriver initialization code for each of our pages.*/
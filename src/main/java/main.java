import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;

public class main {

    public static void main(String[] args) {
        //FacebookCleanser facebookCleanser = new FacebookCleanser();
        WebDriver driver = setUpDriver();
        driver.get("http://www.facebook.com");
    }

    private static WebDriver setUpDriver() {
        System.setProperty("webdriver.gecko.driver",
                "C:"+ File.separator + "Users" + File.separator +"patrick"
                        + File.separator + "Desktop" + File.separator + "geckodriver.exe" );

        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}

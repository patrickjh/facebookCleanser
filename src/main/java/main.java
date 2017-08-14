import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;

public class main {

    public static void main(String[] args) {
        WebDriver driver = setUpDriver();
        FacebookProxy facebook = new FacebookProxy(driver);
        facebook.home();
    }

    private static WebDriver setUpDriver() {
        System.setProperty("webdriver.gecko.driver",
                "C:"+ File.separator + "Users" + File.separator +"patrick"
                        + File.separator + "Desktop" + File.separator + "geckodriver.exe" );

        return new FirefoxDriver();
    }
}

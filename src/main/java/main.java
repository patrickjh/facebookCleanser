import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

public class main {

    public static void main(String[] args) {
        System.out.println("testing");


        System.setProperty("webdriver.gecko.driver",
                "C:"+ File.separator + "Users" + File.separator +"patrick"
                        + File.separator + "Desktop" + File.separator + "geckodriver.exe" );

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.facebook.com");
    }
}

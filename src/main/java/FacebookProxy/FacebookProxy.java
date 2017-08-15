package FacebookProxy;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class FacebookProxy {

    private WebDriver driver;
    private WebElement currentElement;

    public FacebookProxy(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver = driver;
    }

    public FacebookProxy home() {
        driver.get("http://www.facebook.com");
        return this;
    }

    public FacebookProxy login(String email, String password) {
        WebElement login = driver.findElement(By.xpath("//input[@data-testid='royal_email']"));
        login.sendKeys(email);
        return this;
    }
}

package FacebookProxy;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import static FacebookProxy.FacebookLocations.*;

public class FacebookProxy {

    private final WebDriver driver;

    public FacebookProxy(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver = driver;
    }

    public FacebookProxy home() {
        driver.get(HomePage.URL);
        return this;
    }

    public FacebookProxy login(String email, String password) {
        driver.get(LoginPage.URL);

        driver.findElement(By.xpath(LoginPage.EMAIL_ADDRESS_FIELD_XPATH)).sendKeys(email);
        driver.findElement(By.xpath(LoginPage.PASSWORD_FIELD_XPATH)).sendKeys(password);
        driver.findElement(By.xpath(LoginPage.LOGIN_BUTTON_XPATH)).submit();

        return this;
    }

    public FacebookProxy allActivityPage() {

        try {
            driver.findElement(By.xpath(HomePage.PROFILE_PAGE_BUTTON_XPATH)).click();
        } catch (ElementNotFoundException e) {
            driver.get(HomePage.URL);
            driver.findElement(By.xpath(HomePage.PROFILE_PAGE_BUTTON_XPATH)).click();
        }
        driver.findElement(By.xpath(ProfilePage.ALL_ACTIVITY_PAGE_BUTTON_XPATH)).click();

        return this;
    }
}

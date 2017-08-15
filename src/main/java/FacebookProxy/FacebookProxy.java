package FacebookProxy;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import static FacebookProxy.FacebookLocations.*;

public class FacebookProxy {

    private WebDriver driver;

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
}

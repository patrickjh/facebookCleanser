import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookProxy {

    private WebDriver driver;
    private WebElement currentElement;

    public FacebookProxy(WebDriver driver) {
        this.driver = driver;
    }

    public FacebookProxy home() {
        driver.get("http://www.facebook.com");
        return this;
    }
}

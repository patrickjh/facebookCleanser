package FacebookProxy;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import static FacebookProxy.FacebookLocations.*;

public class FacebookProxy {

    private final WebDriver driver;

    public FacebookProxy(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
    }

    public FacebookProxy login(String email, String password) {
        driver.get(LoginPage.URL);

        driver.findElement(By.xpath(LoginPage.EMAIL_ADDRESS_FIELD_XPATH)).sendKeys(email);
        driver.findElement(By.xpath(LoginPage.PASSWORD_FIELD_XPATH)).sendKeys(password);
        driver.findElement(By.xpath(LoginPage.LOGIN_BUTTON_XPATH)).submit();

        waitForFacebook();

        return this;
    }

    public FacebookProxy goToAllPostsPage() {
        this.home().profilePage().allActivityPage().clickYourPostsButton();

        return this;
    }

    public FacebookProxy deleteTopPost() {
        try {
            this.findAndDeletePost();
        }  catch (ElementNotFoundException e) {
            this.scrollDown().findAndDeletePost();
        }

        return this;
    }

    private void waitForFacebook() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(5);
        }
    }

    private FacebookProxy home() {
        driver.get(HomePage.URL);
        return this;
    }

    private FacebookProxy profilePage() {
        driver.findElement(By.xpath(HomePage.PROFILE_PAGE_BUTTON_XPATH)).click();

        return this;
    }

    private FacebookProxy allActivityPage() {
        driver.findElement(By.xpath(ProfilePage.ALL_ACTIVITY_PAGE_BUTTON_XPATH)).click();

        return this;
    }

    private FacebookProxy clickYourPostsButton() {
        driver.findElement(By.xpath(AllActivityPage.YOUR_POSTS_BUTTON_XPATH)).click();

        return this;
    }

    private FacebookProxy clickFirstEditPostButton() {
        driver.findElement(By.xpath(AllActivityPage.FIRST_POST_EDIT_BUTTON_XPATH)).click();

        return this;
    }

    private FacebookProxy clickDeleteButton() {
        driver.findElement(By.xpath(AllActivityPage.DELETE_BUTTON_XPATH)).click();

        return this;
    }

    private FacebookProxy clickConfirmDeleteButton() {
        driver.findElement(By.xpath(AllActivityPage.CONFIRM_DELETE_BUTTON_XPATH)).click();

        return this;
    }

    private FacebookProxy scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,250);");

        return this;
    }

    private FacebookProxy findAndDeletePost() {
        this.clickFirstEditPostButton()
                .clickDeleteButton();

        waitForFacebook();
        this.clickConfirmDeleteButton();

        return this;
    }
}

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

    public FacebookProxy goToAllCommentsPage() {
        this.home().profilePage().allActivityPage().clickCommentsButton();

        return this;
    }

    public FacebookProxy deleteTopPost() {
        int i = 0;
         do {
            try {
                this.findAndDeletePost();
                return this;
            } catch (Exception e) {
                e.printStackTrace();
                this.scrollDown().waitForFacebook();
                i++;
            }
        } while (i < 15);
        return this;
    }

    public FacebookProxy deleteTopComment() {
        int i = 0;
        do {
            try {
                this.findAndDeleteComment().waitForFacebook();
                return this;
            } catch (Exception e) {
                e.printStackTrace();
                this.scrollDown().waitForFacebook();
                i++;
            }
        } while (i < 15);
        return this;
    }

    private FacebookProxy waitForFacebook() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(5);
        }

        return this;
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

    private FacebookProxy clickCommentsButton() {
        driver.findElement(By.xpath(AllActivityPage.COMMENTS_BUTTON_XPATH)).click();

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
        jse.executeScript("scrollBy(0,250);");

        return this;
    }

    private FacebookProxy findAndDeleteComment() {
        this.clickFirstEditPostButton().clickDeleteButton();

        return this;
    }

    private FacebookProxy findAndDeletePost() {
        this.clickFirstEditPostButton().clickDeleteButton();

        waitForFacebook();

        try {
            this.clickConfirmDeleteButton();
        } catch (ElementNotInteractableException e) {
            this.clickConfirmDeleteButton();
        }
        return this;
    }
}

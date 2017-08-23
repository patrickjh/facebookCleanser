import FacebookProxy.FacebookProxy;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;

public class main {

    public static void main(String[] args) {
        WebDriver driver = setUpDriver();

        FacebookProxy facebook = new FacebookProxy(driver);
        facebook.login();

        deleteAllPosts(facebook);

        //deleteAllComments(facebook);




    }

    private static WebDriver setUpDriver() {
        System.setProperty("webdriver.gecko.driver",
                "C:"+ File.separator + "Users" + File.separator +"patrick"
                        + File.separator + "Desktop" + File.separator + "geckodriver.exe" );

        return new FirefoxDriver();
    }

    private static void deleteAllComments(FacebookProxy facebook) {
        int i=0;
        while(true) {
            facebook.goToAllCommentsPage().goToYear("2008").deleteTopComment();
            i++;
            System.out.println(Integer.toString(i) + "Comments Deleted");
        }

    }

    private static void deleteAllPosts(FacebookProxy facebook) {
        int i = 0;

        while(true) {
            facebook.goToAllPostsPage().goToYear("2008").deleteTopPost();
            i++;
            System.out.println(Integer.toString(i) + "Posts Deleted");
        }
    }
}

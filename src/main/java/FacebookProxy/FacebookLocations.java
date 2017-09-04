package FacebookProxy;

class FacebookLocations {

    private FacebookLocations() {}

    static class LoginPage {
        static final String URL = "http://www.facebook.com/login.php";

        static final String EMAIL_ADDRESS_FIELD_XPATH = "//input[@id='email']";

        static final String PASSWORD_FIELD_XPATH = "//input[@id='pass']";

        static final String LOGIN_BUTTON_XPATH = "//button[@id='loginbutton']";
    }

    static class HomePage {

        static final String URL = "http://www.facebook.com";

        static final String PROFILE_PAGE_BUTTON_XPATH = "//div[@data-click='profile_icon']";
    }

    static class ProfilePage {
        static final String ALL_ACTIVITY_PAGE_BUTTON_XPATH = "//a[text() ='View Activity Log']";
    }

    static class AllActivityPage {
        static final String FIRST_POST_EDIT_BUTTON_XPATH ="//a[1 and @data-tooltip-content='Allowed on timeline']";

        static final String YOUR_POSTS_BUTTON_XPATH = "//a[@title='Your Posts']";

        static final String DELETE_BUTTON_XPATH = "//span[text()='Delete']";

        static final String CONFIRM_DELETE_BUTTON_XPATH = "//button[text() = 'Delete Post']";

        static final String COMMENTS_BUTTON_XPATH = "//a[@title='Comments']";
    }

    static class AllCommentsPage {
        static String commentsYearButtonXpath(String year) {
            return"//li[@data-key='year_" + year + "']";
        }
    }


}

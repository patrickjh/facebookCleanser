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

        static final String PROFILE_PAGE_BUTTON_XPATH = "//a[@data-testid='blue_bar_profile_link']";
    }

    static class ProfilePage {
        static final String ALL_ACTIVITY_PAGE_BUTTON_XPATH = "//a[@data-testid='view_activity_cover_button']";
    }

    static class AllActivityPage {
        static final String FIRST_POST_EDIT_BUTTON_XPATH ="//a[1 and @data-testid='pencil_icon_link']";

        static final String YOUR_POSTS_BUTTON_XPATH = "//a[@title='Your Posts']";

        static final String DELETE_BUTTON_XPATH = "//span[text()='Delete']";

        static final String CONFIRM_DELETE_BUTTON_XPATH = "//button[text() = 'Delete Post']";
    }


}

package FacebookProxy;

class FacebookLocations {

    private FacebookLocations() {}

    static class LoginPage {
        static final String URL = "http://www.facebook.com";

        static final String EMAIL_ADDRESS_FIELD_XPATH = "//input[@data-testid='royal_email']";

        static final String PASSWORD_FIELD_XPATH = "//input[@data-testid='royal_pass']";

        static final String LOGIN_BUTTON_XPATH = "//input[@data-testid='royal_login_button']";
    }

    static class HomePage {

        static final String URL = "http://www.facebook.com";
    }


}

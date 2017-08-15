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
    }


}

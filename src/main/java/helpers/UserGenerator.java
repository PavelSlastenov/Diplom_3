package helpers;

import models.LoginUser;
import models.RegisterUser;

import static helpers.DataGenerator.randomString;


public class UserGenerator {
    final static String DEFAULT_EMAIL = randomString(8) + "@" + randomString(4) + ".ru";
    final static String DEFAULT_PASSWORD = randomString(10);
    final static String DEFAULT_NAME = randomString(6);

    public static RegisterUser getDefaultRegistrationData() {
        return new RegisterUser(DEFAULT_EMAIL, DEFAULT_PASSWORD, DEFAULT_NAME);
    }

    public static LoginUser getDefaultLoginData() {
        return new LoginUser(DEFAULT_EMAIL, DEFAULT_PASSWORD, DEFAULT_NAME);
    }
}

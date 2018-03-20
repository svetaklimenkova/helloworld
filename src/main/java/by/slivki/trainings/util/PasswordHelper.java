package by.slivki.trainings.util;

import org.apache.commons.lang.RandomStringUtils;

public class PasswordHelper {
    public static String generatePassword() {
        return RandomStringUtils.randomAlphabetic(8);
    }
}

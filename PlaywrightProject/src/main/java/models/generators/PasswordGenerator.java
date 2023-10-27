package models.generators;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {

    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final String PUNCTUATION = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    private static final String PASSWORD_ALLOW =
            CHAR_LOWERCASE + CHAR_UPPERCASE + DIGIT + PUNCTUATION;

    private static SecureRandom random = new SecureRandom();

    private PasswordGenerator () {

    }

    public static String generatePassword(int passwordLength) {
        StringBuilder result = new StringBuilder(passwordLength);
        String strLowerCase = generateRandomString(CHAR_LOWERCASE, 2);
        result.append(strLowerCase);
        String strUppercaseCase = generateRandomString(CHAR_UPPERCASE, 2);
        result.append(strUppercaseCase);
        String strDigit = generateRandomString(DIGIT, 2);
        result.append(strDigit);
        String strSpecialChar = generateRandomString(PUNCTUATION, 2);
        result.append(strSpecialChar);
        String strOther = generateRandomString(PASSWORD_ALLOW, passwordLength - 8);
        result.append(strOther);
        String password = result.toString();
        shuffleString(password);
        return password;
    }

    private static String generateRandomString(String input, int size) {
        if (input == null || input.length() <= 0)
            throw new IllegalArgumentException("Invalid input.");
        if (size < 1) throw new IllegalArgumentException("Invalid size.");
        StringBuilder result = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(input.length());
            result.append(input.charAt(index));
        }
        return result.toString();
    }

    private static String shuffleString(String input) {
        List<String> result = Arrays.asList(input.split(""));
        Collections.shuffle(result);
        return String.join("", result);
    }

}
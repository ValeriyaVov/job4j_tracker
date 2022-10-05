package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        String rsl = null;
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if (password.length() <= 7 || password.length() >= 33) {
            rsl = "Password length must be in the range [8, 32]";
        }
        String[] array = {"qwerty",
                "12345",
                "password",
                "admin",
                "user"};

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        boolean hasSubstring = false;
        String singleRegister = null;

        for (int i = 0; i < array.length; i++) {
            singleRegister = password.toLowerCase();
            if (singleRegister.contains(array[i])) {
                hasSubstring = true;
            }
        }
        for (int i = 0; i < password.length(); i++) {
            int p = password.charAt(i);
            if (isUpperLatinLetter(p)) {
                hasUppercase = true;
            }
            if (isLowerLatinLetter(p)) {
                hasLowercase = true;
            }
            if (Character.isDigit(p)) {
                hasDigit = true;
            }
            if (isSpecialSymbol(p)) {
                hasSymbol = true;
            }

        }
        if (!hasUppercase) {
            rsl = "Password must contain at least one uppercase character";
        }
        if (!hasLowercase) {
            rsl = "Password must contain at least one lowercase character";
        }
        if (!hasDigit) {
            rsl = "The password must contain at least one number";
        }
        if (!hasSymbol) {
            rsl = "The password must contain at least one special symbol";
        }
        if (hasSubstring) {
            rsl = "The password must not contain case-insensitive substrings";
        }
        return rsl;
    }

    public static boolean isUpperLatinLetter(int code) {
        return code >= 65 && code <= 90;
    }

    public static boolean isLowerLatinLetter(int code) {
        return code >= 97 && code <= 122;
    }

    public static boolean isSpecialSymbol(int code) {
        return code == 36 || code == 95;
    }
}

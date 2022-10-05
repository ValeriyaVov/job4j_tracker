package ru.job4j.early;

import org.hamcrest.Matchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class PasswordValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordIsNull() {
        PasswordValidator.validate(null);
    }

    @Test
    public void whenPasswordIsValid() {
        String message = PasswordValidator.validate("IGEMik_01");
        MatcherAssert.assertThat(message, Matchers.nullValue());
    }

    @Test
    public void whenPasswordLengthIsFive() {
        String message = PasswordValidator.validate("Ik_01");
        String warning = "Password length must be in the range [8, 32]";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordLengthIsEight() {
        String message = PasswordValidator.validate("Ik_01_0R");
        MatcherAssert.assertThat(message, Matchers.nullValue());
    }

    @Test
    public void whenPasswordLengthIsThirtyThree() {
        String message = PasswordValidator.validate("Ik_01_000023rrweiurqbbbnYYYlasUIo");
        String warning = "Password length must be in the range [8, 32]";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordLengthIsThirtyTwo() {
        String message = PasswordValidator.validate("Ik_01_000023rrweiurqbbbnYYYlasIo");
        MatcherAssert.assertThat(message, Matchers.nullValue());
    }

    @Test
    public void whenNoUppercaseCharacter() {
        String message = PasswordValidator.validate("u_76jerdfoh");
        String warning = "Password must contain at least one uppercase character";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenNoLowercaseCharacter() {
        String message = PasswordValidator.validate("OYWE_3_5FA");
        String warning = "Password must contain at least one lowercase character";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenNoOneNumber() {
        String message = PasswordValidator.validate("Tk_iioKrE");
        String warning = "The password must contain at least one number";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenNoOneSpecialSymbol() {
        String message = PasswordValidator.validate("Tk823iioKrE");
        String warning = "The password must contain at least one special symbol";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainSubstring() {
        String message = PasswordValidator.validate("adminTk823iioKrE");
        String warning = "The password must not contain case-insensitive substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainOnlySubstringUser() {
        String message = PasswordValidator.validate("po_usER$ok7");
        String warning = "The password must not contain case-insensitive substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainSubstringPass() {
        String message = PasswordValidator.validate("659_passworD");
        String warning = "The password must not contain case-insensitive substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainOnlySubstringQwerty() {
        String message = PasswordValidator.validate("QWERTY$8ipe");
        String warning = "The password must not contain case-insensitive substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainOnlySubstringNumber() {
        String message = PasswordValidator.validate("12345_Kk$");
        String warning = "The password must not contain case-insensitive substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }
}
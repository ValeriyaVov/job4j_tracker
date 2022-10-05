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
    public void whenPasswordLengthIsSeven() {
        String message = PasswordValidator.validate("Ik_01_y");
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
    public void whenNoNumber() {
        String message = PasswordValidator.validate("Tk_iioKrE");
        String warning = "Password must contain at least one number";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenNoOneSpecialSymbol() {
        String message = PasswordValidator.validate("Tk823iioKrE");
        String warning = "Password must contain at least one special symbol";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainsSubstring() {
        String message = PasswordValidator.validate("adminTk823iioKrE");
        String warning = "Password must not contain popular substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainsSubstringUser() {
        String message = PasswordValidator.validate("po_usER$ok7");
        String warning = "Password must not contain popular substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainsSubstringPass() {
        String message = PasswordValidator.validate("659_passworD");
        String warning = "Password must not contain popular substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainsSubstringQwerty() {
        String message = PasswordValidator.validate("QWERTY$8ipe");
        String warning = "Password must not contain popular substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }

    @Test
    public void whenPasswordContainsSubstringNumber() {
        String message = PasswordValidator.validate("12345_Kk$");
        String warning = "Password must not contain popular substrings";
        MatcherAssert.assertThat(message, Matchers.is(warning));
    }
}
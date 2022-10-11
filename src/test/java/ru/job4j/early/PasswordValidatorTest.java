package ru.job4j.early;

import org.hamcrest.Matchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PasswordValidatorTest {

    @Test
    public void whenPasswordIsNull() {
        try {
            PasswordValidator.validate(null);
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password cannot be empty"));
        }

    }

    @Test
    public void whenPasswordIsValid() {
        String message = PasswordValidator.validate("IGEMik_01");
        MatcherAssert.assertThat(message, Matchers.is("Password is valid"));
    }

    @Test
    public void whenPasswordLengthIsSeven() {
        try {
            PasswordValidator.validate("Ik_01_y");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password length must be in the range [8, 32]"));
        }
    }

    @Test
    public void whenPasswordLengthIsEight() {
            String message = PasswordValidator.validate("Ik_01_0R");
            MatcherAssert.assertThat(message, Matchers.is("Password is valid"));
    }

    @Test
    public void whenPasswordLengthIsThirtyThree() {
        try {
            PasswordValidator.validate("Ik_01_000023rrweiurqbbbnYYYlasUIo");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            String warning = "Password length must be in the range [8, 32]";
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is(warning));
        }
    }

    @Test
    public void whenPasswordLengthIsThirtyTwo() {
            String message = PasswordValidator.validate("Ik_01_000023rrweiurqbbbnYYYlasIo");
            MatcherAssert.assertThat(message, Matchers.is("Password is valid"));
    }

    @Test
    public void whenNoUppercaseCharacter() {
        try {
            PasswordValidator.validate("u_76jerdfoh");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must contain at least one uppercase character"));
        }
    }

    @Test
    public void whenNoLowercaseCharacter() {
        try {
            PasswordValidator.validate("OYWE_3_5FA");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must contain at least one lowercase character"));
        }
    }

    @Test
    public void whenNoNumber() {
        try {
            PasswordValidator.validate("Tk_iioKrE");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must contain at least one number"));
        }
    }

    @Test
    public void whenNoOneSpecialSymbol() {
        try {
            PasswordValidator.validate("Tk823iioKrE");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must contain at least one special symbol"));
        }
    }

    @Test
    public void whenPasswordContainsSubstring() {
        try {
            PasswordValidator.validate("adminTk823ii$oKrE");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must not contain popular substrings"));
        }
    }

    @Test
    public void whenPasswordContainsSubstringUser() {
        try {
            PasswordValidator.validate("po_usER$ok7");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must not contain popular substrings"));
        }
    }

    @Test
    public void whenPasswordContainsSubstringPass() {
        try {
            PasswordValidator.validate("659_passworD");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must not contain popular substrings"));
        }
    }

    @Test
    public void whenPasswordContainsSubstringQwerty() {
        try {
            PasswordValidator.validate("QWERTY$8ipe");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must not contain popular substrings"));
        }
    }

    @Test
    public void whenPasswordContainsSubstringNumber() {
        try {
            PasswordValidator.validate("12345_Kk$");
            fail("Expected exception was not received");
        } catch (IllegalArgumentException exception) {
            MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Password must not contain popular substrings"));
        }
    }
}
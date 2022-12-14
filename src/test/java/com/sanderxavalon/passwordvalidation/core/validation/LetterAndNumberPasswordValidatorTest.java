package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.common.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LetterAndNumberPasswordValidatorTest {

    LetterAndNumberPasswordValidator letterAndNumberPasswordValidator;

    @BeforeEach
    void setup(){
        letterAndNumberPasswordValidator = new LetterAndNumberPasswordValidator();
        letterAndNumberPasswordValidator.setNext(new NoOpsValidator());
    }

    @Test
    void no_lowercase_letter_throw_exception(){
        String password = "123456";
        Assertions.assertThrows(ValidationException.class, () -> {
            letterAndNumberPasswordValidator.check(password);
        });
    }

    @Test
    void no_digit_number_throw_exception(){
        String password = "abcdef";
        Assertions.assertThrows(ValidationException.class, () -> {
            letterAndNumberPasswordValidator.check(password);
        });
    }

    @Test
    void contain_uppercase_letter_throw_exception(){
        String password = "123abcABC";
        Assertions.assertThrows(ValidationException.class, () -> {
            letterAndNumberPasswordValidator.check(password);
        });
    }

    @Test
    void contain_punctuation_throw_exception(){
        String password = "123abc;!@#";
        Assertions.assertThrows(ValidationException.class, () -> {
            letterAndNumberPasswordValidator.check(password);
        });
    }
}

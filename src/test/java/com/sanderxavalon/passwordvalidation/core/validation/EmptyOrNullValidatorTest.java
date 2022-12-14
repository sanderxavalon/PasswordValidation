package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.common.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmptyOrNullValidatorTest {

    EmptyOrNullValidator emptyOrNullValidator;

    @BeforeEach
    void setup(){
        emptyOrNullValidator = new EmptyOrNullValidator();
        emptyOrNullValidator.setNext(new NoOpsValidator());
    }

    @Test
    void assert_not_null_and_does_not_throw() {
        String password = "NotNull";
        Assertions.assertDoesNotThrow(() -> {
            emptyOrNullValidator.check(password);
        });
    }

    @Test
    void assert_null_and_throw_exception() {
        String password = null;
        Assertions.assertThrows(ValidationException.class, () -> {
            emptyOrNullValidator.check(password);
        });
    }

    @Test
    void assert_not_empty_and_does_not_throw() {
        String password = "NotEmpty";
        Assertions.assertDoesNotThrow(() -> {
            emptyOrNullValidator.check(password);
        });
    }

    @Test
    void assert_empty_and_throw_exception(){
        String password = "";
        Assertions.assertThrows(ValidationException.class, () -> {
            emptyOrNullValidator.check(password);
        });

    }
}

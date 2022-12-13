package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoSequencePasswordValidatorTest {

    @Autowired
    NoSequencePasswordValidator noSequencePasswordValidator;

    @Test
    void regular_password() {
        String password = "ABCDEF";
        Assertions.assertDoesNotThrow(() -> {
            noSequencePasswordValidator.check(password);
        });
    }

    @Test
    void repeat_first_3_words() {
        String password = "ABCABCDEFGHI";
        Assertions.assertThrows(ValidationException.class, () -> {
            noSequencePasswordValidator.check(password);
        });
    }

}

package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.common.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class NoSequencePasswordValidatorTest {

    NoSequencePasswordValidator noSequencePasswordValidator;

    @BeforeEach
    void setup(){
        noSequencePasswordValidator = new NoSequencePasswordValidator();
        noSequencePasswordValidator.setNext(new NoOpsValidator());
    }

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

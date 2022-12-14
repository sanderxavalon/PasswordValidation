package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.common.exception.ValidationException;
import com.sanderxavalon.passwordvalidation.entity.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxAndMinPasswordValidatorTest {

    MaxAndMinPasswordValidator maxAndMinPasswordValidator;
    List<Config> configs = new ArrayList<>();

    @BeforeEach
    void setup(){

        maxAndMinPasswordValidator = new MaxAndMinPasswordValidator();
        maxAndMinPasswordValidator.setNext(new NoOpsValidator());

        Config minValue = new Config();
        minValue.setConfigKey("passwordMinLength");
        minValue.setConfigValue(5);

        Config maxValue = new Config();
        maxValue.setConfigKey("passwordMaxLength");
        maxValue.setConfigValue(12);

        configs.add(minValue);
        configs.add(maxValue);

        maxAndMinPasswordValidator.update(configs);
    }

    @Test
    void within_range() {
        String password = "ABCDEF";
        Assertions.assertDoesNotThrow(() -> {
            maxAndMinPasswordValidator.check(password);
        });
    }

    @Test
    void less_than_5_throw_exception(){
        String password = "ABC";
        Assertions.assertThrows(ValidationException.class, () -> {
            maxAndMinPasswordValidator.check(password);
        });
    }

    @Test
    void more_than_12_throw_exception(){
        String password = "ABCDEFGHIJKLMN";
        Assertions.assertThrows(ValidationException.class, () -> {
            maxAndMinPasswordValidator.check(password);
        });
    }



}

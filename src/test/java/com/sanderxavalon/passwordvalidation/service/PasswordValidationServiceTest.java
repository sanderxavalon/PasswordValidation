package com.sanderxavalon.passwordvalidation.service;

import com.sanderxavalon.passwordvalidation.core.common.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
public class PasswordValidationServiceTest {

    @Autowired
    PasswordValidationService passwordValidationService;

    @Test
    void regular_password() {
        String password = "123456abc";
        Assertions.assertDoesNotThrow(() -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void assert_null_and_throw_exception() {
        String password = null;
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void assert_empty_and_throw_exception(){
        String password = "";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void no_lowercase_letter_throw_exception(){
        String password = "123456";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void no_digit_number_throw_exception(){
        String password = "abcdef";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void contain_uppercase_letter_throw_exception(){
        String password = "123abcABC";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void contain_punctuation_throw_exception(){
        String password = "123abc;!@#";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void less_than_5_throw_exception(){
        String password = "ABC";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void more_than_12_throw_exception(){
        String password = "ABCDEFGHIJKLMN";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void repeat_first_3_words() {
        String password = "ABCABCDEFGHI";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void repeat_internal_3_words() {
        String password = "DEFABCABCGHI";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

    @Test
    void repeat_last_3_words() {
        String password = "DEFGHIABCABC";
        Assertions.assertThrows(ValidationException.class, () -> {
            passwordValidationService.validatePassword(password);
        });
    }

}

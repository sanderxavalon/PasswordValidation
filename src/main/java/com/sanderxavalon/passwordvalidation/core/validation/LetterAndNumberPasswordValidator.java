package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.exception.ValidationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Order(1)
@Component
public class LetterAndNumberPasswordValidator extends PasswordValidator{

    @Override
    public void check(String password) {
        checkContainsOneLowercaseLetter(password);
        checkContainsOneNumber(password);
        checkContainsInvalidCharacter(password);
        callNext(password);
    }

    private void checkContainsOneLowercaseLetter(String password) {
        if (!Pattern.compile("[a-z]{1}").matcher(password).find()){
            throw new ValidationException("Password does not contain more than one lower case character");
        }
    }

    private void checkContainsOneNumber(String password) {
        if (!Pattern.compile("[1-9]{1}").matcher(password).find()){
            throw new ValidationException("Password does not contain more than one lower case character");
        }
    }

    private void checkContainsInvalidCharacter(String password) {
        if (Pattern.compile("[^a-z1-9\n]{1}").matcher(password).find()){
            throw new ValidationException("Password does not contain more than one lower case character");
        }
    }
}

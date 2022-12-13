package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.exception.ValidationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class EmptyOrNullValidator extends PasswordValidator{

    @Override
    public void check(String password) {
        checkNull(password);
        checkEmpty(password);
        callNext(password);
    }

    private void checkNull(String password) {
        if (password == null) {
            throw new ValidationException("Password is null");
        }
    }

    private void checkEmpty(String password) {
        if (password.isEmpty()) {
            throw new ValidationException("Password is empty");
        }
    }
}

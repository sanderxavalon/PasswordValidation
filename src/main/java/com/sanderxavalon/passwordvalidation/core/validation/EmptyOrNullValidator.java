package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.common.exception.ValidationException;
import com.sanderxavalon.passwordvalidation.core.common.response.StatusEnum;
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
            throw new ValidationException(StatusEnum.PASSWORD_IS_NULL);
        }
    }

    private void checkEmpty(String password) {
        if (password.isEmpty()) {
            throw new ValidationException(StatusEnum.PASSWORD_IS_EMPTY);
        }
    }
}

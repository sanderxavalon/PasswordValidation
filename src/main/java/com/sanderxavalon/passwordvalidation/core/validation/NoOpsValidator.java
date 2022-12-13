package com.sanderxavalon.passwordvalidation.core.validation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class NoOpsValidator extends PasswordValidator {

    @Override
    public void check(String password) {

    }

    @Override
    protected void callNext(String password) {

    }

}

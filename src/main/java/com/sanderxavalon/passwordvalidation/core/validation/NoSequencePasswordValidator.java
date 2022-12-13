package com.sanderxavalon.passwordvalidation.core.validation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(3)
@Component
public class NoSequencePasswordValidator extends PasswordValidator{

    @Override
    public void check(String password) {

    }

}

package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.common.exception.SystemException;
import com.sanderxavalon.passwordvalidation.core.common.response.StatusEnum;
import com.sanderxavalon.passwordvalidation.core.config.Observer;
import com.sanderxavalon.passwordvalidation.core.common.exception.ValidationException;
import com.sanderxavalon.passwordvalidation.core.config.entity.Config;
import com.sanderxavalon.passwordvalidation.core.config.ConfigService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(2)
@Component
public class MaxAndMinPasswordValidator extends PasswordValidator implements Observer {

    private Integer passwordMinLength;
    private Integer passwordMaxLength;

    @Override
    public void check(String password) {
        checkMinLength(password);
        checkMaxLength(password);
        callNext(password);
    }

    @Override
    public void update(List<Config> configs) {

        Integer passwordMinLength = ConfigService.getConfigValue(configs, "passwordMinLength");
        Integer passwordMaxLength = ConfigService.getConfigValue(configs, "passwordMaxLength");

        if (passwordMinLength > passwordMaxLength) {
            throw new SystemException(StatusEnum.SYSTEM_MIN_IS_MORE_THAN_MAX);
        }

        this.passwordMinLength = passwordMinLength;
        this.passwordMaxLength = passwordMaxLength;

    }

    private void checkMinLength(String password) {
        if (password.length() < this.passwordMinLength ) {
            throw new ValidationException(StatusEnum.PASSWORD_IS_LESS_THAN_MIN_REQUIRE);
        }
    }

    private void checkMaxLength(String password) {
        if (password.length() > this.passwordMaxLength ) {
            throw new ValidationException(StatusEnum.PASSWORD_IS_MORE_THAN_MAX_REQUIRE);
        }
    }
}

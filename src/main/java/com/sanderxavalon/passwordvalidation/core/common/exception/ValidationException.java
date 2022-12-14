package com.sanderxavalon.passwordvalidation.core.common.exception;

import com.sanderxavalon.passwordvalidation.core.common.response.StatusEnum;
import org.springframework.util.StringUtils;

public class ValidationException extends RuntimeException {

    private StatusEnum statusEnum;

    public ValidationException(StatusEnum statusEnum){
        super();
        this.statusEnum = statusEnum;
    }

    public ValidationException(StatusEnum statusEnum, String message) {
        super(message);
        this.statusEnum = statusEnum;
    }

    public boolean isMessageExist() {
        return StringUtils.hasText(this.getMessage());
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}

package com.sanderxavalon.passwordvalidation.core.common.exception;

import com.sanderxavalon.passwordvalidation.core.common.response.Result;
import com.sanderxavalon.passwordvalidation.core.common.response.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ValidationException.class)
    public Result handleValidationException(ValidationException validationException){
        logger.warn(validationException.toString());
        if (validationException.isMessageExist()){
            return new Result(validationException.getStatusEnum(), validationException.getMessage());
        }
        return new Result(validationException.getStatusEnum());
    }

    @ExceptionHandler(SystemException.class)
    public Result handleSystemException(SystemException systemException){
        logger.error(systemException.toString());
        return new Result(systemException.getStatusEnum());
    }

    @ExceptionHandler(Exception.class)
    public Result handleAllException(Exception exception){
        logger.error(exception.toString());
        return new Result(StatusEnum.ERROR, exception.getMessage());
    }
}

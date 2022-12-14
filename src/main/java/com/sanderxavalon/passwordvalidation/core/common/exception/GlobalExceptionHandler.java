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

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception exception){
        logger.error(exception.toString());
        return new Result(StatusEnum.ERROR, exception.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public Result handleValidationException(ValidationException validationException){
        logger.info(validationException.toString());
        if (validationException.isMessageExist()){
            return new Result(validationException.getStatusEnum(), validationException.getMessage());
        }
        return new Result(validationException.getStatusEnum());
    }

}

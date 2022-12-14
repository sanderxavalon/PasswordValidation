package com.sanderxavalon.passwordvalidation.core.common.response;


import com.fasterxml.jackson.annotation.JsonInclude;

public class Result<T> {

    private Integer status;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result(StatusEnum statusEnum){
        this.status = statusEnum.getStatus();
        this.message = statusEnum.getMessage();
        this.data = null;
    }

    public Result(StatusEnum statusEnum, T data){
        this.status = statusEnum.getStatus();
        this.message = statusEnum.getMessage();
        this.data = data;
    }

    public static Result QuickSuccess(){
        return new Result(StatusEnum.SUCCESS);
    }

    public static <T> Result<T> QuickSuccess(T data){
        return new Result<T>(StatusEnum.SUCCESS, data);
    }

    public static Result QuickFail(){
        return new Result(StatusEnum.FAIL);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

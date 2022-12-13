package com.sanderxavalon.passwordvalidation.core.validation;

public abstract class PasswordValidator {

    private PasswordValidator next;

    public abstract void check(String password);

    protected void callNext(String password) {
        next.check(password);
    }

    public void setNext(PasswordValidator next) {
        this.next = next;
    }
}

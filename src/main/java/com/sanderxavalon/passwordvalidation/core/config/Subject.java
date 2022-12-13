package com.sanderxavalon.passwordvalidation.core.config;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyAllObserver();
}

package com.gergert.task1.observer;

public interface ArrayObservable {
    void addArrayObserver(ArrayObserver observer);
    void removeArrayObserver(ArrayObserver observer);
    void notifyArrayObservers();
}

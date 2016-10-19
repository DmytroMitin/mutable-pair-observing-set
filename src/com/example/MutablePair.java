package com.example;

import java.util.Observable;

/**
 * Created by dmitin on 19.10.16.
 */
public class MutablePair<T, U> extends Observable {
    private T value1;
    private U value2;

    public T getValue1() {
        return value1;
    }

    public U getValue2() {
        return value2;
    }

    public void setValue1(T value1) {
        T oldValue1 = this.value1;
        this.value1 = value1;
        setChanged();
        notifyObservers(new MutablePair<>(oldValue1, this.value2));
    }

    public void setValue2(U value2) {
        U oldValue2 = this.value2;
        this.value2 = value2;
        setChanged();
        notifyObservers(new MutablePair<>(this.value1, oldValue2));
    }

    public MutablePair(T value1, U value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || object.getClass() != MutablePair.class) return false;

        MutablePair<T, U> that = (MutablePair<T, U>) object;

        if (this.value1 != null ? !this.value1.equals(that.value1) : that.value1 != null) return false;
        return this.value2 != null ? this.value2.equals(that.value2) : that.value2 == null;

    }

    @Override
    public int hashCode() {
        int result = value1 != null ? value1.hashCode() : 0;
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "(" +
                value1 +
                ", " + value2 +
                ')';
    }
}

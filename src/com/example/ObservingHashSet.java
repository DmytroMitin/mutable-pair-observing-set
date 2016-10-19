package com.example;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by dmitin on 19.10.16.
 */
public class ObservingHashSet<T extends Observable> extends HashSet<T> implements Observer {
    @Override
    public void update(Observable newEl, Object oldEl) {
        T oldElement = (T) oldEl;
        T newElement = (T) newEl;
        remove(oldElement);
        if (add(newElement)) {
            newEl.addObserver(this);
        }
    }

    @Override
    public boolean add(T t) {
        t.addObserver(this);
        return super.add(t);
    }

    @Override
    public boolean remove(Object object) {
        if (object instanceof Observable) {
            ((Observable) object).deleteObserver(this);
        }
        return super.remove(object);
    }
}

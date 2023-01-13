package org.example.stackqueues;

import java.util.EmptyStackException;

public class FixedStack {

    private Object[] data;

    public FixedStack(int capacity) {
        this.data = new Object[capacity];
    }

    public Object[] getBackingArray() {
        return data;
    }

    public void push(Object object) {
    }

    public Object pop() {
        return null;
    }

    public Object peek() {
        return null;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int search(Object object) {
        return -1;
    }
}

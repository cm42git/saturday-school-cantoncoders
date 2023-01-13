package org.example.stackqueues;

import java.util.EmptyStackException;

public class FixedStack {

    private Object[] data;
    private int lastInIndex;

    public FixedStack(int capacity) {
        this.data = new Object[capacity];
    }

    public Object[] getBackingArray() {
        return data;
    }

    public void push(Object object) {
        int i = 0;
        for (; i < data.length; i++) {
            if (data[i] == null)
                break;
        }
        if (i != data.length)
            data[i] = object;
        else
            throw new StackFullException();
    }

    public Object pop() {
        int i = 0;
        for (; i < data.length; i++) {
            if (data[i] == null)
                break;
        }
        i--;
        if (i >= 0) {
            Object out = data[i];
            data[i] = null;
            return out;
        } else
            throw new EmptyStackException();
    }

    public Object peek() {
        int i = 0;
        for (; i < data.length; i++) {
            if (data[i] == null)
                break;
        }
        i--;
        if (i >= 0)
            return data[i];
        else
            throw new EmptyStackException();
    }

    public boolean isFull() {
        for (Object object : data) {
            if (object == null)
                return false;
        }
        return true;
    }

    public boolean isEmpty() {
        for (Object object : data) {
            if (object != null)
                return false;
        }
        return true;
    }

    public int search(Object object) {
        for (int i = 0; i < data.length; i++) {
            if (object.equals(data[i]))
                return data.length - i;
        }
        return -1;
    }
}

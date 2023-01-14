package org.example.stackqueues;

import java.util.EmptyStackException;

public class FlexibleStack {
    private Object[] data;
    private int lastInIndex = -1;

    public FlexibleStack(int capacity) {
        this.data = new Object[capacity];
    }

    public Object[] getBackingArray() {
        return data;
    }

    public void push(Object object) {
        lastInIndex++;
        if (lastInIndex > data.length - 1) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[lastInIndex] = object;
    }

    public Object pop() {
        if (lastInIndex < 0)
            throw new EmptyStackException();
        Object popObj = data[lastInIndex];
        data[lastInIndex] = null;
        lastInIndex--;
        return popObj;
    }

    public Object peek() {
        if (lastInIndex < 0)
            throw new EmptyStackException();
        return data[lastInIndex];
    }

    public boolean isFull() {
        return lastInIndex == data.length - 1;
    }

    public boolean isEmpty() {
        return lastInIndex == -1;
    }

    public int search(Object object) {
        for (int i = 0; i <= lastInIndex; i++) {
            if (object.equals(data[i]))
                return data.length - i;
        }
        return -1;
    }
}

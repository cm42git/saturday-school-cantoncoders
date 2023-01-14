package org.example.stackqueues;

import java.util.EmptyStackException;

public class FixedStack {

    private Object[] data;
    private int lastInIndex = -1;

    public FixedStack(int capacity) {
        this.data = new Object[capacity];
    }

    public Object[] getBackingArray() {
        return data;
    }

    public void push(Object object) {
        if (lastInIndex != data.length - 1) {
            lastInIndex++;
            data[lastInIndex] = object;
        } else
            throw new StackFullException();
    }

    public Object pop() {
        if (lastInIndex >= 0) {
            Object out = data[lastInIndex];
            data[lastInIndex] = null;
            lastInIndex--;
            return out;
        } else
            throw new EmptyStackException();
    }

    public Object peek() {
        if (lastInIndex >= 0)
            return data[lastInIndex];
        else
            throw new EmptyStackException();
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

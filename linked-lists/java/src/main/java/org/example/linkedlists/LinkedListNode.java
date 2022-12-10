package org.example.linkedlists;

import java.util.Arrays;

public class LinkedListNode<T> {
    private final T element;
    private LinkedListNode<T> next;
    private LinkedListNode<T> previous;
    private int size;

    public LinkedListNode(T element) {
        this.element = element;
    }

    public static <E> LinkedListNode<E> buildLinkedList(E ...elements) {
        var firstNode = new LinkedListNode<E>(elements[0]);

        var node = firstNode;
        boolean first = true;
        int s = 1;
        for (E e : elements) {
            if (first) {
                first = false;
                continue;
            }
            node.setNext(new LinkedListNode<>(e));
            node.getNext().setPrevious(node);
            node = node.getNext();
            s++;
        }
        firstNode.size = s;
        // firstNode.setPrevious(node);
        return firstNode;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T getElement() {
        return element;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    public LinkedListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode<T> node) {
        this.previous = node;
    }

    public int getSize() {
        return this.size;
    }
}

package org.example.linkedlists;

import java.util.HashSet;

public class RemoveDuplicates {

    public static <T> void remove(LinkedListNode<T> node) {
        var seen = new HashSet<>();
        while (node.hasNext()) {
            if (seen.contains(node.getElement())) {
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
            } else {
                seen.add(node.getElement());
            }
            node = node.getNext();
        }
        
        if (seen.contains(node.getElement())) {
            node.getPrevious().setNext(node.getNext());
        }
    }
}
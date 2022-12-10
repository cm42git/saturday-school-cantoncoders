package org.example.linkedlists;

public class RemoveMiddle {
    public static void remove(LinkedListNode<Integer> node) {
        int removeHalf = (node.getSize() -1) / 2;
        for (int i = 0; i < removeHalf; i++) {
            node = node.getNext();
        }
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }
}

package org.example.linkedlists;

public class RemoveMiddle {
    public static void remove(LinkedListNode<Integer> node) {
        int removeHalf = (node.getSize() - 1) / 2;
        for (int i = 0; i < removeHalf; i++) {
            node = node.getNext();
        }

        // Nathan's implementations

        /* var i = 1;

        while (node.hasNext()) {
            node = node.getNext();
            i++;
        }

        // O (n)
        i = i / 2;
        for (; i > 0; i--) {
            node = node.getPrevious();
        } */

        /* var middle = node;

        var i = 1;
        while (node.hasNext()) {
            node = node.getNext();
            if (i % 2 == 0) {
                middle = middle.getNext();
            }
            i++;
        } */

        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }
}

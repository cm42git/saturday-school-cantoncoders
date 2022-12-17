package org.example.linkedlists;

public class FindNode {

    /*
     * Consider the algorithm efficiency:
     * - Does it use recursion or does it iterate?
     * - What is the time complexity?
     *
     * @param nth - The number of nodes from the end. A 0 value would be the last
     * node, and 3 would be second to last.
     * 
     * @param head - The head node of the LinkedList
     * 
     * @return The node at nth away from the end.
     */
    public static LinkedListNode<Integer> findNthFromEnd(int nth, LinkedListNode<Integer> head) {
        // if (nth == 0 && !head.hasNext()) {
        // return head;
        // } else if (nth == 1 && !(head.getNext().hasNext())) {
        // return head;
        // } else {
        if (nth >= head.getSize()) {
            return null;
        }
        LinkedListNode<Integer> n = head;
        int size = 1;
        while (n.hasNext()) {
            size++;
            n = n.getNext();
        }

        n = head;
        for (int i = 1; i < size - nth; i++) {
            n = n.getNext();
        }

        return n;
        // }
        /* var tail = node;
        var head = node;

        for (int i = nth; i > 0; i--) {
            tail = tail.getNext();
        }

        while (tail.hasNext()) {
            tail = tail.getNext();
            head = head.getNext();
        }

        return head; */
    }
}

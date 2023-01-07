package org.example.linkedlists;

import java.util.HashSet;

public class LoopDetection {
    public static <E> Node<E> findLoopNode(Node<E> node) {
        var seen = new HashSet<>();
        while (node.hasNext()) {
            seen.add(node);
            if (seen.contains(node.getNext())) {
                return node.getNext();
            }
            node = node.getNext();
        }
        return null;
    }
}

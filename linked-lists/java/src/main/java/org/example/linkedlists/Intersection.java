package org.example.linkedlists;

import java.util.HashSet;

public class Intersection {
    public static <E> Node<E> findIntersect(Node<E> left, Node<E> right) {
        var lookupSet = new HashSet<>();
        while (left.hasNext()) {
            lookupSet.add(left);
            left = left.getNext();
        }
        lookupSet.add(left);

        while (right.hasNext()) {
            if (lookupSet.contains(right)) {
                return right;
            } else {
                right = right.getNext();
            }
        }
        if (lookupSet.contains(right)) {
            return right;
        }

        return null;
    }
}

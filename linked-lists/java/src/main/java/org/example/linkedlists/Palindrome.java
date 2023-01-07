package org.example.linkedlists;

import java.util.Stack;

public class Palindrome {
    public static <T> boolean isPalindrome(Node<T> node) {
        var reverse = new Stack<T>();
        var nodeReverse = node;
        while (nodeReverse.hasNext()) {
            reverse.push(nodeReverse.getElement());
            nodeReverse = nodeReverse.getNext();
        }
        reverse.push(nodeReverse.getElement());

        while (node.hasNext()) {
            if (node.getElement().equals(reverse.peek())) {
                reverse.pop();
            }
            node = node.getNext();
        }
        if (node.getElement().equals(reverse.peek())) {
            reverse.pop();
        }

        return reverse.size() == 0;
        /*
         * var check = new ArrayList<Node<T>>();
         * var matches = 0;
         * check.add(node);
         * if (node.hasNext()) {
         * node = node.getNext();
         * check.add(node);
         * matches = node.getElement().equals(check.get(0).getElement()) ? 1 : 0;
         * } else {
         * return true;
         * }
         * 
         * var checkElementIndex = 0;
         * while (node.hasNext()) {
         * node = node.getNext();
         * check.add(node);
         * Node<T> checkNode = check.get(checkElementIndex);
         * if (node.getElement().equals(checkNode.getElement())) {
         * matches += 1;
         * }
         * checkElementIndex = check.size() - (2 - check.size() % 2);
         * 
         * }
         * 
         * var neededMatches = (check.size() / 2);
         * return matches == neededMatches;
         */
    }
}

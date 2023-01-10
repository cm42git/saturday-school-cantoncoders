package org.example.linkedlists;

public class SumListReversed {
    public static SinglyLinkedNode<Integer> addSum(SinglyLinkedNode<Integer> l1, SinglyLinkedNode<Integer> l2) {
        var tempSum = l1.getElement() + l2.getElement();
        var carryTen = tempSum >= 10;
        var sumList = new SinglyLinkedNode<>(tempSum % 10);
        var finalList = sumList;
        while (l1.hasNext() && l2.hasNext()) {
            l1 = l1.getNext();
            l2 = l2.getNext();
            tempSum = l1.getElement() + l2.getElement() + (carryTen ? 1 : 0);
            carryTen = false;

            var nodeToAdd = SinglyLinkedNode.buildLinkedList(tempSum % 10);
            sumList.setNext(nodeToAdd);
            sumList = sumList.getNext();
            carryTen = tempSum >= 10;

            if (l1.hasNext() && !l2.hasNext()) {
                l2.setNext(SinglyLinkedNode.buildLinkedList(0));
            }
            if (!l1.hasNext() && l2.hasNext()) {
                l1.setNext(SinglyLinkedNode.buildLinkedList(0));
            }
        }

        return finalList;

        /* Nathan Carver's elegant solution, built TDD
        SinglyLinkedNode<Integer> head = null;
        SinglyLinkedNode<Integer> tail = null;
        
        var carry = 0;
        
        while (l1 != null || l2 != null || carry > 0) {
            var v1 = l1 != null ? l1.getElement() : 0;
            var v2 = l2 != null ? l2.getElement() : 0;
        
            var sum = v1 + v2 + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
        
            var newNode = new SinglyLinkedNode<>(sum);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        
            l1 = l1 != null ? l1.getNext() : null;
            l2 = l2 != null ? l2.getNext() : null;
        }
        ;
        
        return head; */
    }
}

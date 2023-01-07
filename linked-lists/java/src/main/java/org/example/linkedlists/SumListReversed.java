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
    }
}

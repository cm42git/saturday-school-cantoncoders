package org.example.linkedlists;
import java.util.Arrays;

public class SumListInOrder {
    static SinglyLinkedNode<Integer> outList = null;
    static boolean carryTen = false;

    public static SinglyLinkedNode<Integer> addSum(SinglyLinkedNode<Integer> l1, SinglyLinkedNode<Integer> l2) {
        var tempL1 = l1;
        var tempL2 = l2;

        while (tempL1.hasNext() && tempL2.hasNext()) {
            tempL1 = tempL1.getNext();
            tempL2 = tempL2.getNext();
        }
        while (tempL1.hasNext()) {
            var zero = SinglyLinkedNode.buildLinkedList(0);
            zero.setNext(l2);
            l2 = zero;
            tempL1 = tempL1.getNext();
        }
        while (tempL2.hasNext()) {
            var zero = SinglyLinkedNode.buildLinkedList(0);
            zero.setNext(l1);
            l1 = zero;
            tempL2 = tempL2.getNext();
        }

        recurseListSum(l1, l2);

        if (carryTen && outList.getElement() == 0) {
            var addOne = new SinglyLinkedNode<>(1);
            addOne.setNext(outList);
            outList = addOne;
        }

        var outList2 = outList;

        outList = null;
        carryTen = false;
        return outList2;
    }

    private static void recurseListSum(SinglyLinkedNode<Integer> n1, SinglyLinkedNode<Integer> n2) {

        if (n1 == null)
            return;

        if (n1.hasNext())
            recurseListSum(n1.getNext(), n2.getNext());

        int tempSum = n1.getElement() + n2.getElement() + (carryTen ? 1 : 0);
        carryTen = tempSum >= 10;
        var addToTotal = new SinglyLinkedNode<>(tempSum % 10);
        if (outList != null) {
            addToTotal.setNext(outList);
        }

        outList = addToTotal;
    }
}

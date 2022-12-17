package org.example.linkedlists;

public class Partition {

  public static <T extends Comparable<T>> LinkedListNode<T> partitionByValue(LinkedListNode<T> node, T value) {
    LinkedListNode<T> insertGTE = node;
    var linkedListPartitioned = node;

    if (node.getSize() <= 1)
      return node;

    while (linkedListPartitioned.hasNext()) {
      if (linkedListPartitioned.getElement().compareTo(value) < 0) {
        // move insertion point to element greater than or equal to value
        if (linkedListPartitioned == insertGTE) {
          insertGTE = linkedListPartitioned.getNext();
        } else {
          moveNode(insertGTE, linkedListPartitioned);
        }

      }
      linkedListPartitioned = linkedListPartitioned.getNext();
    }

    if (linkedListPartitioned.getElement().compareTo(value) < 0)
      moveNode(insertGTE, linkedListPartitioned);

    while (linkedListPartitioned.getPrevious() != null) {
      linkedListPartitioned = linkedListPartitioned.getPrevious();
    }

    return linkedListPartitioned;
  }

  private static <T extends Comparable<T>> void moveNode(LinkedListNode<T> insertGTE,
      LinkedListNode<T> linkedListPartitioned) {
    if (linkedListPartitioned.getPrevious() != insertGTE) {
      linkedListPartitioned.getPrevious().setNext(linkedListPartitioned.getNext());
      if (linkedListPartitioned.getNext() != null)
        linkedListPartitioned.getNext().setPrevious(linkedListPartitioned.getPrevious());
    }
    insertBefore(linkedListPartitioned, insertGTE);
  }

  public static <T extends Comparable<T>> void insertBefore(LinkedListNode<T> node, LinkedListNode<T> nodeAfter) {
    // only a problem if we are swapping the nodes
    if (node.getPrevious() == nodeAfter) {
      nodeAfter.setNext(node.getNext());
    }
    // in case swapping with the first element
    if (nodeAfter.getPrevious() != null) {
      nodeAfter.getPrevious().setNext(node);
    }

    node.setNext(nodeAfter);
    node.setPrevious(nodeAfter.getPrevious());
    nodeAfter.setPrevious(node);
  }

}
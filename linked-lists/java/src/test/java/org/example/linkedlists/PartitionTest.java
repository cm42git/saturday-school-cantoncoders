package org.example.linkedlists;

import org.junit.jupiter.api.Test;
import static org.example.linkedlists.LinkedListAssert.*;

public class PartitionTest {

  @Test
  public void listAlreadyPartitioned() {
    var node = LinkedListNode.buildLinkedList(1, 5, 10);
    var head = Partition.partitionByValue(node, 5);
    validateWithRange(head, 1, 5, 10);
  }

  @Test
  public void partitionSmallListToTheLeft() {
    var node = LinkedListNode.buildLinkedList(6, 1, 10);
    var head = Partition.partitionByValue(node, 6);
    validateWithRange(head, 1, 6, 10);
  }

  @Test
  public void longList() {
    var node = LinkedListNode.buildLinkedList(6, 1, 10, 3, 2, 8, 11, 4, 5);
    var head = Partition.partitionByValue(node, 5);

    var second = head.getNext();
    for (int i = 0; i < 3; i++) {
      second = second.getNext();
    }

    second.getPrevious().setNext(null);

    validateListContains(head, 1, 3, 2, 4);
    validateListContains(second, 6, 10, 8, 11, 5);
  }

  @Test
  public void longInOrder() {
    var node = LinkedListNode.buildLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    var head = Partition.partitionByValue(node, 5);
    validateWithRange(head, 1, 2, 3, 4, 5, 6, 7, 8, 9);
  }

  @Test
  public void longOppositeOrder() {
    var node = LinkedListNode.buildLinkedList(9, 8, 7, 6, 5, 4, 3, 2, 1);
    var head = Partition.partitionByValue(node, 5);
    validateWithRange(head, 4, 3, 2, 1, 9, 8, 7, 6, 5);
  }

  @Test
  public void longList2() {
    var node = LinkedListNode.buildLinkedList(6, 1, 10, 3, 2, 8, 11, 5, 4);
    var head = Partition.partitionByValue(node, 5);

    var second = head.getNext();
    for (int i = 0; i < 3; i++) {
      second = second.getNext();
    }

    second.getPrevious().setNext(null);

    validateListContains(head, 1, 3, 2, 4);
    validateListContains(second, 6, 10, 8, 11, 5);
  }

  @Test
  public void shortList() {
    var node = LinkedListNode.buildLinkedList(1);
    var head = Partition.partitionByValue(node, 5);
    validateWithRange(head, 1);
  }

}
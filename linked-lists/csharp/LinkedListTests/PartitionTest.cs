using System.Collections.Generic;
using static LinkedLists.LinkedListAssert;

namespace LinkedLists
{
    public class PartitionTest
    {
        [Test]
        public void ListAlreadyPartitioned()
        {
            var node = LinkedListNode<int>.BuildLinkedList(1, 5, 10);
            var head = Partition<int>.PartitionByValue(node, 5);
            ValidateWithRange(head, 1, 5, 10);
        }

        [Test]
        public void PartitionSmallListToTheLeft()
        {
            var node = LinkedListNode<int>.BuildLinkedList(6, 1, 10);
            var head = Partition<int>.PartitionByValue(node, 6);
            ValidateWithRange(head, 1, 6, 10);
        }

        [Test]
        public void LongList()
        {
            var node = LinkedListNode<int>.BuildLinkedList(6, 1, 10, 3, 2, 8, 11, 4, 5);
            var head = Partition<int>.PartitionByValue(node, 5);

            var second = head.Next;
            for (int i = 0; i < 3; i++)
            {
                second = second.Next;
            }
            second.Previous.Next = null;

            ValidateListContains(head, 1, 3, 2, 4);
            ValidateListContains(second, 6, 10, 8, 11, 5);
        }

        [Test]
        public void LongInOrder()
        {
            var node = LinkedListNode<int>.BuildLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            var head = Partition<int>.PartitionByValue(node, 5);
            ValidateWithRange(head, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        }

        [Test]
        public void LongOppositeOrder()
        {
            var node = LinkedListNode<int>.BuildLinkedList(9, 8, 7, 6, 5, 4, 3, 2, 1);
            var head = Partition<int>.PartitionByValue(node, 5);
            ValidateWithRange(head, 4, 3, 2, 1, 9, 8, 7, 6, 5);
        }

    }
}

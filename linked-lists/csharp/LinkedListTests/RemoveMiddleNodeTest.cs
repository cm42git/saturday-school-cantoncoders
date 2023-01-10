using static LinkedLists.LinkedListAssert;

namespace LinkedLists
{
    public class RemoveMiddleNodeTest
    {
        [Test]
        public void RemoveFromOddNumberShortList()
        {
            var node = LinkedListNode<int>.BuildLinkedList(3, 4, 5);
            RemoveMiddle.Remove(node);
            ValidateWithRange(node, 3, 5);
        }

        [Test]
        public void RemoveFromOddNumberLongList()
        {
            var node = LinkedListNode<int>.BuildLinkedList(3, 4, 5, 7, 1, 10, 99);
            RemoveMiddle.Remove(node);
            ValidateWithRange(node, 3, 4, 5, 1, 10, 99);
        }

        [Test]
        public void RemoveFromEvenNumberShortList()
        {
            var node = LinkedListNode<int>.BuildLinkedList(3, 4, 5, 10);
            RemoveMiddle.Remove(node);
            ValidateWithRange(node, 3, 5, 10);
        }

        [Test]
        public void RemoveFromEvenNumberLongList()
        {
            var node = LinkedListNode<int>.BuildLinkedList(3, 4, 5, 7, 1, 10, 99, 6);
            RemoveMiddle.Remove(node);
            ValidateWithRange(node, 3, 4, 5, 1, 10, 99, 6);
        }
    }
}

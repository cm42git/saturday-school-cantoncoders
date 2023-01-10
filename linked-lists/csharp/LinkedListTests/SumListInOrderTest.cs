using static LinkedLists.LinkedListAssert;

namespace LinkedLists
{
    public class SumListInOrderTest
    {
        [Test]
        public void ReturnSingleDigitOnesPosition()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(3);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(5);
            var sum = SumListInOrder.AddSum(list1, list2);
            ValidateWithRange(sum, 8);
        }

        [Test]
        public void returnSingleDigitAtTensPosition()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(2, 7);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(4, 1);
            var sum = SumListInOrder.AddSum(list1, list2);
            ValidateWithRange(sum, 6, 8);
        }

        [Test]
        public void ReturnCoverOverAtHundredsPosition()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(3, 1, 2);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(3, 6, 7);
            var sum = SumListInOrder.AddSum(list1, list2);
            ValidateWithRange(sum, 6, 7, 9);
        }

        [Test]
        public void ReturnCoverOverAtUnequalListLength()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(3, 1, 2);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(8, 3, 6, 7);
            var sum = SumListInOrder.AddSum(list1, list2);
            ValidateWithRange(sum, 8, 6, 7, 9);
        }

        [Test]
        public void ReturnCoverOverAtUnequalListLengthSwitched()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(9, 8, 4, 6);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(5, 1, 2);
            var sum = SumListInOrder.AddSum(list1, list2);
            ValidateWithRange(sum, 1, 0, 3, 5, 8);
        }

        [Test]
        public void ReturnCoverOverAtUnequalListLengthByTwo()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(9, 8, 4, 6);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(9, 7);
            var sum = SumListInOrder.AddSum(list1, list2);
            ValidateWithRange(sum, 9, 9, 4, 3);
        }
    }
}

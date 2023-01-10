using static LinkedLists.LinkedListAssert;

namespace LinkedLists
{
    public class SumReversedTest
    {
        [Test]
        public void ReturnSingleDigitOnesPosition()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(3);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(5);
            var sum = SumListReversed.AddSum(list1, list2);
            ValidateWithRange(sum, 8);
        }

        [Test]
        public void ReturnSingleDigitAtTensPosition()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(7, 2);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(1, 4);
            var sum = SumListReversed.AddSum(list1, list2);
            ValidateWithRange(sum, 8, 6);
        }

        [Test]
        public void ReturnCoverOverAtHundredsPosition()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(2, 1, 3);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(7, 6, 3);
            var sum = SumListReversed.AddSum(list1, list2);
            ValidateWithRange(sum, 9, 7, 6);
        }

        [Test]
        public void ReturnCoverOverAtUnequalListLength()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(2, 1, 3);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(7, 6, 3, 8);
            var sum = SumListReversed.AddSum(list1, list2);
            ValidateWithRange(sum, 9, 7, 6, 8);
        }

        [Test]
        public void ReturnCoverOverAtUnequalListLengthSwitched()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(2, 1, 3, 8);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(7, 6, 3);
            var sum = SumListReversed.AddSum(list1, list2);
            ValidateWithRange(sum, 9, 7, 6, 8);
        }

        [Test]
        public void ReturnCoverOverAtUnequalListLengthByTwo()
        {
            var list1 = SinglyLinkedNode<int>.BuildLinkedList(6, 5, 3, 8);
            var list2 = SinglyLinkedNode<int>.BuildLinkedList(7, 6);
            var sum = SumListReversed.AddSum(list1, list2);
            ValidateWithRange(sum, 3, 2, 4, 8);
        }
    }
}

using static LinkedLists.LinkedListAssert;

namespace LinkedLists
{
    public class RemoveDuplicatesTest
    {
        [Test]
        public void ThereCanBeOnlyOne()
        {
            var node = LinkedListNode<int>.BuildLinkedList(1);
            RemoveDuplicates.Remove(node);
            ValidateWithRange(node, 1);
        }

        [Test]
        public void NoDuplicates()
        {
            var node = LinkedListNode<int>.BuildLinkedList(1, 2, 3, 4, 5);
            RemoveDuplicates.Remove(node);
            ValidateWithRange(node, 1, 2, 3, 4, 5);
        }

        [Test]
        public void OnePairedDuplicate()
        {
            var node = LinkedListNode<int>.BuildLinkedList(1, 1, 2, 3, 4, 5);
            RemoveDuplicates.Remove(node);
            ValidateWithRange(node, 1, 2, 3, 4, 5);
        }

        [Test]
        public void OneNonPairedDuplicate()
        {
            var node = LinkedListNode<int>.BuildLinkedList(1, 2, 10, 9, 1, 5);
            RemoveDuplicates.Remove(node);
            ValidateWithRange(node, 1, 2, 10, 9, 5);
        }

        [Test]
        public void TwoNonPairedDuplicate()
        {
            var node = LinkedListNode<int>.BuildLinkedList(5, 1, 2, 10, 9, 1, 5);
            RemoveDuplicates.Remove(node);
            ValidateWithRange(node, 5, 1, 2, 10, 9);
        }

        /* EXTRA CREDIT */
        /* Refactor the method to take a LinkedListNode with an element that extends Object */
        [Test]
        public void MakeTheMethodGeneric()
        {
            var node = LinkedListNode<string>.BuildLinkedList("Cat", "Dog", "dog", "Cat", "Dog", "Bear", "Bird");
            RemoveDuplicates.Remove(node);
            ValidateWithRange(node, "Cat", "Dog", "dog", "Bear", "Bird");
        }

        /* TEST for the LinkedListNode builder function */
        [Test]
        public void NodeListBuilder()
        {
            var node1 = LinkedListNode<int>.BuildLinkedList(1, 2, 3);

            Assert.That(node1.Previous, Is.Null);
            Assert.That(node1.GetElement(), Is.EqualTo(1));
            Assert.That(node1.GetNext(), Is.Not.Null);

            LinkedListNode<int> node2 = (LinkedListNode<int>)node1.GetNext();
            Assert.That(node2.Previous, Is.EqualTo(node1));
            Assert.That(node2.GetNext(), Is.Not.Null);
            Assert.That(node2.GetElement(), Is.EqualTo(2));

            LinkedListNode<int> node3 = (LinkedListNode<int>)node2.GetNext();
            Assert.That(node3.Previous, Is.EqualTo(node2));
            Assert.That(node3.GetNext(), Is.Null);
            Assert.That(node3.GetElement(), Is.EqualTo(3));

        }
    }
}

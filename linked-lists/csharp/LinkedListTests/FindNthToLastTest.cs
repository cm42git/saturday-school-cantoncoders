namespace LinkedLists
{
    public class FindNthToLastTest
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void FindSingleNode()
        {
            var head = LinkedListNode<int>.BuildLinkedList(1);
            var node = FindNode.FindNthFromEnd(0, head);
            Assert.That(node, Is.Not.Null);
            Assert.That(node.GetElement(), Is.EqualTo(1));
        }

        [Test]
        public void FindLastNodeAmountTwo()
        {
            var head = LinkedListNode<int>.BuildLinkedList(1, 2);
            var node = FindNode.FindNthFromEnd(0, head);
            Assert.That(node, Is.Not.Null);
            Assert.That(node.GetElement(), Is.EqualTo(2));
        }

        [Test]
        public void FindNodeSecondToLastAmongTwo()
        {
            var head = LinkedListNode<int>.BuildLinkedList(1, 2);
            var node = FindNode.FindNthFromEnd(1, head);
            Assert.That(node, Is.Not.Null);
            Assert.That(node.GetElement(), Is.EqualTo(1));
        }

        [Test]
        public void FindNodeSecondToLastAmongFive()
        {
            var head = LinkedListNode<int>.BuildLinkedList(1, 2, 4, 3, 7);
            var node = FindNode.FindNthFromEnd(2, head);
            Assert.That(node, Is.Not.Null);
            Assert.That(node.GetElement(), Is.EqualTo(4));
        }

        [Test]
        public void FindNode5thToLastAmongFive()
        {
            var head = LinkedListNode<int>.BuildLinkedList(1, 2, 4, 3, 7, 10);
            var node = FindNode.FindNthFromEnd(5, head);
            Assert.That(node, Is.Not.Null);
            Assert.That(node.GetElement(), Is.EqualTo(1));
        }

        [Test]
        public void NthIsLargerThanList()
        {
            var head = LinkedListNode<int>.BuildLinkedList(1, 2, 4, 3, 7, 10);
            var node = FindNode.FindNthFromEnd(6, head);
            Assert.That(node, Is.Null);
        }
    }
}
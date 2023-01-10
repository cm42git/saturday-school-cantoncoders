namespace LinkedLists
{
    public class LoopDetectionTest
    {
        [Test]
        public void ListDoesNotLoop()
        {
            var node = SinglyLinkedNode<int>.BuildLinkedList(1, 3, 5, 11, 12);
            Assert.That(LoopDetection.FindLoopNode(node), Is.Null);
        }

        [Test]
        public void DoesNotLoopOnEqualElements()
        {
            var value = 5;
            var node = SinglyLinkedNode<int>.BuildLinkedList(1, 3, value, 11, 12, value);
            Assert.That(LoopDetection.FindLoopNode<int>(node), Is.Null);
        }

        [Test]
        public void LoopsOnNodeReference()
        {
            var loopStart = new SinglyLinkedNode<int>(3);
            var segment1 = SinglyLinkedNode<int>.BuildLinkedList(1, 3);
            var segment2 = SinglyLinkedNode<int>.BuildLinkedList(11, 12);

            GetListTail(segment1).Next = loopStart;
            loopStart.Next = segment2;
            GetListTail(segment2).Next = loopStart;

            Assert.That(LoopDetection.FindLoopNode<int>(segment1), Is.EqualTo(loopStart));
        }

        [Test]
        public void LargeLoopSet()
        {
            var value = 5;
            var loopStart = new SinglyLinkedNode<int>(3);
            var segment1 = SinglyLinkedNode<int>.BuildLinkedList(1, 3, value, 39, 12, 8, 33);
            var segment2 = SinglyLinkedNode<int>.BuildLinkedList(11, 12, value, 23, 91, 100, 21, 48);

            GetListTail(segment1).Next = loopStart;
            loopStart.Next = segment2;
            GetListTail(segment2).Next = loopStart;

            Assert.That(LoopDetection.FindLoopNode<int>(segment1), Is.EqualTo(loopStart));
        }

        private static SinglyLinkedNode<T> GetListTail<T>(SinglyLinkedNode<T> node)
        {
            while (node != null && node.HasNext())
            {
                node = node.GetNext();
            }
            return node;
        }
    }
}

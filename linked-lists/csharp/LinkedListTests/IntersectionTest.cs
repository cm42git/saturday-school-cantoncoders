namespace LinkedLists
{
    public class IntersectionTest
    {
        [Test]
        public void NodesDoNotIntersect()
        {
            var left = SinglyLinkedNode<int>.BuildLinkedList(1, 3, 5);
            var right = SinglyLinkedNode<int>.BuildLinkedList(11, 13, 14);
            Assert.That(Intersection.FindIntersect(left, right), Is.Null);
        }

        [Test]
        public void NodesIntersectAtTail()
        {
            var intersect = SinglyLinkedNode<int>.BuildLinkedList(7);

            var left = SinglyLinkedNode<int>.BuildLinkedList(1, 3, 5);
            var right = SinglyLinkedNode<int>.BuildLinkedList(11, 13, 14);

            GetListTail(left).Next = intersect;
            GetListTail(right).Next = intersect;

            Assert.That(Intersection.FindIntersect(left, right), Is.EqualTo(intersect));
        }

        [Test]
        public void NodesIntersect()
        {
            var intersect = SinglyLinkedNode<int>.BuildLinkedList(2, 7);

            var left = SinglyLinkedNode<int>.BuildLinkedList(1, 3, 5);
            var right = SinglyLinkedNode<int>.BuildLinkedList(11, 13, 14);

            GetListTail(left).Next = intersect;
            GetListTail(right).Next = intersect;

            Assert.That(Intersection.FindIntersect(left, right), Is.EqualTo(intersect));
        }

        [Test]
        public void NodesEqualElementsDoNotIntersect()
        {
            var value = 2;

            var left = SinglyLinkedNode<int>.BuildLinkedList(1, 3, 5, value, 7);
            var right = SinglyLinkedNode<int>.BuildLinkedList(11, 13, 14, value, 7);

            Assert.That(Intersection.FindIntersect(left, right), Is.Null);
        }

        [Test]
        public void UnequalLengthListIntersect()
        {
            var intersect = SinglyLinkedNode<int>.BuildLinkedList(5, 2, 7);

            var left = SinglyLinkedNode<int>.BuildLinkedList(1, 3, 5, 11, 12);
            var right = SinglyLinkedNode<int>.BuildLinkedList(11, 13, 14);

            GetListTail(left).Next = intersect;
            GetListTail(right).Next = intersect;

            Assert.That(Intersection.FindIntersect(left, right), Is.EqualTo(intersect));
        }

        [Test]
        public void IntersectByReference()
        {
            var value = 5;

            var intersect = SinglyLinkedNode<int>.BuildLinkedList(value, 2, 7);

            var left = SinglyLinkedNode<int>.BuildLinkedList(value, 13, 14);
            var right = SinglyLinkedNode<int>.BuildLinkedList(1, 3, value, 11, 14);

            GetListTail(left).Next = intersect;
            GetListTail(right).Next = intersect;

            Assert.That(Intersection.FindIntersect(left, right), Is.EqualTo(intersect));
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

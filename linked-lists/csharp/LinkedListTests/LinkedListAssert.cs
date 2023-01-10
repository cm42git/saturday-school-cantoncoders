using System.Collections;

namespace LinkedLists
{
    public class LinkedListAssert
    {
        public static void ValidateWithRange<T>(INode<T> node, params T[] expected)
        {
            var actual = new ArrayList();

            actual.Add(node.GetElement());
            while (node != null && node.HasNext())
            {
                node = node.GetNext();
                actual.Add(node.GetElement());
            }

            Assert.That(actual, Is.EqualTo(expected));
        }

        public static void ValidateListContains<T>(INode<T> node, params T[] expected)
        {
            var actual = new ArrayList();

            actual.Add(node.GetElement());
            while (node != null && node.HasNext())
            {
                node = node.GetNext();
                actual.Add(node.GetElement());
            }

            Assert.That(actual, Is.EquivalentTo(expected));
        }
    }
}

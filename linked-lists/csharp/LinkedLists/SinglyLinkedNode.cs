namespace LinkedLists
{
    public class SinglyLinkedNode<T> : INode<T>
    {
        private readonly T element;
        public SinglyLinkedNode<T>? Next { get; set; }

        public SinglyLinkedNode(T element)
        {
            this.element = element;
        }

        public static SinglyLinkedNode<T> BuildLinkedList(params T[] elements)
        {
            var firstNode = new SinglyLinkedNode<T>(elements[0]);

            var node = firstNode;
            bool first = true;
            foreach (T e in elements)
            {
                if (first)
                {
                    first = false;
                    continue;
                }
                node.Next = new SinglyLinkedNode<T>(e);
                node = node.GetNext();
            }

            return firstNode;
        }

        public T GetElement()
        {
            return element;
        }

        public bool HasNext()
        {
            return Next != null;
        }

        public override string ToString()
        {
            return "SinglyLinkedNode{" +
                "ref=" + GetHashCode() +
                ", element=" + element +
                ", hasNext=" + HasNext() +
                "}";
        }

        INode<T>? INode<T>.GetNext()
        {
            return Next;
        }

        public SinglyLinkedNode<T>? GetNext()
        {
            return Next;
        }
    }
}

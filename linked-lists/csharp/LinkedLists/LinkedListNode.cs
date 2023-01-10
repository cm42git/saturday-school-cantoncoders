namespace LinkedLists
{
    public class LinkedListNode<T> : INode<T>
    {
        private readonly T element;
        public LinkedListNode<T>? Next { get; set; }
        public LinkedListNode<T>? Previous { get; set; }
        public int Size { get; private set; }

        public LinkedListNode(T element)
        {
            this.element = element;
        }

        public static LinkedListNode<T> BuildLinkedList(params T[] elements)
        {
            var firstNode = new LinkedListNode<T>(elements[0]);

            var node = firstNode;
            bool first = true;
            int s = 1;
            foreach (T e in elements)
            {
                if (first)
                {
                    first = false;
                    continue;
                }
                node.Next = new LinkedListNode<T>(e)
                {
                    Previous = node
                };
                node = node.Next;
                s++;
            }
            firstNode.Size = s;
            return firstNode;
        }

        public bool HasNext()
        {
            return Next != null;
        }

        public T GetElement() { return element; }
        public INode<T>? GetNext() { return Next; }
    }
}

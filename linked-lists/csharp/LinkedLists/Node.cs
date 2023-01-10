namespace LinkedLists
{
    public interface INode<T>
    {
        T GetElement();
        bool HasNext();
        INode<T>? GetNext();
    }
}

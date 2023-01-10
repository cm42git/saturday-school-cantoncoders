﻿namespace LinkedLists
{
    public class SumListInOrder
    {
        public static SinglyLinkedNode<int> AddSum(SinglyLinkedNode<int> l1, SinglyLinkedNode<int> l2)
        {
            return new SinglyLinkedNode<int>(l1.GetElement() + l2.GetElement());
        }
    }
}


namespace LinkedLists
{
    public class PalindromeTest
    {
        [Test]
        public void TwoNodePalindrome()
        {
            var node = SinglyLinkedNode<int>.BuildLinkedList(1, 1);
            Assert.That(Palindrome.IsPalindrome(node), Is.True);
        }

        [Test]
        public void TwoNodeNonPalindrome()
        {
            var node = SinglyLinkedNode<int>.BuildLinkedList(1, 2);
            Assert.That(Palindrome.IsPalindrome(node), Is.False);
        }

        [Test]
        public void ThreeNodePalindrome()
        {
            var node = SinglyLinkedNode<int>.BuildLinkedList(1, 2, 1);
            Assert.That(Palindrome.IsPalindrome(node), Is.True);
        }

        [Test]
        public void ThreeNodeNonPalindrome()
        {
            var node = SinglyLinkedNode<int>.BuildLinkedList(1, 2, 2);
            Assert.That(Palindrome.IsPalindrome(node), Is.False);
        }

        [Test]
        public void FourNodePalindrome()
        {
            var node = SinglyLinkedNode<int>.BuildLinkedList(1, 2, 3, 2, 1);
            Assert.That(Palindrome.IsPalindrome(node), Is.True);
        }

        [Test]
        public void FourNodeNonPalindrome()
        {
            var node = SinglyLinkedNode<int>.BuildLinkedList(2, 1, 3, 2, 1);
            Assert.That(Palindrome.IsPalindrome(node), Is.False);
        }
    }
}

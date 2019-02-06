package hw3help;

/**
 * This class contains some interesting linked list problems,
 * some of which have shown up in technical interviewing
 * scenarios.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class LinkedListProblems
{
    /**
     * Joins together the two input linked lists into a singled linked list.
     * The second linked list elements should come after the first linked
     * list elements. Also, each of the elements in each respective list should
     * maintain their relative order in the joined list.
     *
     * Restrictions: You may not use any auxiliary data structure
     * to help out here, including: Stack, Queue, ArrayList, LinkedList
     * or other structures in Java's collection framework.
     *
     * Hints: Don't over-engineer a solution here. A working algorithm should
     * include a basic traversal and updating a single reference between
     * the lists.
     *
     * Reminders: Be careful to address edge cases such as either list being
     * empty (or both being empty).
     *
     * @param headFirst a reference to the head of a linked list
     * @param headSecond a reference to the head of a linked list
     * @return a reference to the head of the new joined linked list
     */
    public static Node join(Node headFirst, Node headSecond)
    {
        return null;
    }

    /**
     * Takes the input linked list and returns a new linked list with
     * the elements in reverse order.
     *
     * Restrictions: None. Although, extra credit will be awarded to anyone
     * who can solve this without using any auxiliary data structure,
     * including: Stack, Queue, ArrayList, LinkedList or other structures
     * in Java's collection framework. Your solution should only use a few
     * temporary variables to hold nodes as you are making changes to the input list.
     *
     * Hints: Drawing a picture to illustrate your reference changes can
     * be useful here. In particular you should focus on the order in
     * which you need to change references.
     *
     * Reminders: Be careful to address edge cases such as either list being
     * empty.
     *
     * @param head a reference to the head of a linked list
     * @return a head reference to a new linked list with all elements
     * from the input list in reverse order
     */
    public static Node reverse(Node head)
    {
        return null;
    }

    /**
     * Returns the last k elements from a linked list as a new
     * linked list. The elements will be returned in the same
     * order that they were in the input list.
     *
     * Restrictions: None.
     *
     * Hints: Using a Stack can be very useful here.
     *
     * Reminders: Be careful to address edge cases such as either list being
     * empty, the case where k is zero, and when k is larger than the
     * input list size.
     *
     * @param head a reference to the head of a linked list
     * @param k a non-negative integer k
     * @return a reference to a linked list with the last k elements
     * in the input list.
     */
    public static Node lastK(Node head, int k)
    {
        return null;
    }

    /**
     * Partitions the linked list that begins at the provided
     * head node around a value x. All nodes that contain elements
     * less than or equal to x will come before elements that are
     * greater than x.
     *
     * Restrictions: You may not use any auxiliary data structure
     * to help out here, including: Stack, Queue, ArrayList, LinkedList
     * or other structures in Java's collection framework.
     *
     * Hints: Try to identify elements that lie on side of the value
     * x and move them to one end of the linked list.
     *
     * Reminders: Be careful to address edge cases such as the list
     * being empty or only containing a single node.
     *
     * @param head a reference to the head of a linked list
     * @param x a positive integer x
     * @return a reference to the head of a new linked list that is
     *         partitioned around x
     */
    public static Node partition(Node head, int x)
    {
        return null;
    }

    /**
     * Represents a node in a singly linked list.
     *
     * DO NOT ALTER THIS CLASS!
     *
     * @author Josh Archer
     * @version 1.0
     */
    public static class Node
    {
        private int data;
        private Node next;

        /**
         * Create a new Node object
         * @param data the node data
         */
        public Node(int data)
        {
            this.data = data;
        }

        /**
         * Creates a new Node object with next pointer.
         * @param data the node data
         * @param next the next node in the list
         */
        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        /**
         * Retrieves the data in the node.
         * @return the node data
         */
        public int getData()
        {
            return data;
        }

        /**
         * Alters the data in the node
         * @param data the new data for the node
         */
        public void setData(int data)
        {
            this.data = data;
        }

        /**
         * Retrieves the next node referenced by this node.
         * @return the next node
         */
        public Node getNext()
        {
            return next;
        }

        /**
         * Alters the next node referenced by this node.
         * @param next the new next node
         */
        public void setNext(Node next)
        {
            this.next = next;
        }

        @Override
        public String toString()
        {
            return String.valueOf(data);
        }
    }
}

package linkedlists;

public class SortedLL
{
    //fields
    private Node head;
    private int size; //track the number of elements

    //constructor
    public SortedLL()
    {
        //...
    }

    //expected methods for a sorted linked list

    public void add(Comparable newElement)
    {
        //special case, what if the list is empty
        if (head == null)
        {
            head = new Node(newElement);
        }
        //special case, the element is the smallest in the list
        else if (newElement.compareTo(head.data) < 0)
        {
            head = new Node(newElement, head, null);
        }
        //otherwise we need to traverse the list
        else
        {
            Node current = head;

            //search until we find a node with an element larger than newElement
            while (current.next != null &&
                    newElement.compareTo(current.next.data) > 0)
            {
                current = current.next;
            }

            //scenario #1, the new element goes at the end of the list
            if (current.next == null)
            {
                current.next = new Node(newElement, null, current);
            }
            //scenario #2, we found the first node with a larger element
            else
            {
                Node newEntry = new Node(newElement);

                //#1 point the new entry to the larger element
                newEntry.next = current.next;

                //#2 point the smaller element to the new entry
                current.next = newEntry;

                //#3 point the larger element at the new entry
                newEntry.next.prev = newEntry;

                //#4 point the new entry to the smaller element
                newEntry.prev = current;
            }
        }

        size++;
    }

    public Comparable[] toArray()
    {
        Comparable[] results = new Comparable[size];

        //copy elements from the linked list to the array
        Node current = head;
        for (int i = 0; i < size; i++)
        {
            results[i] = current.data;
            current = current.next;
        }

        return results;
    }

    private class Node
    {
        private Comparable data;
        private Node next;
        private Node prev;

        public Node(Comparable data)
        {
            this.data = data;
        }

        public Node(Comparable data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}

package trees;

import org.w3c.dom.Node;

public class TreeMap
{
    //fields?
    private Node root;
    private int size;

    public TreeMap()
    {
        //do nothing...
    }

    public void add(Comparable key, Object value)
    {
        root = add(root, key, value);
    }

    //this method returns the current node being observed,
    //or the new node in the tree once we find its position
    private Node add(Node current, Comparable key, Object value)
    {
        //my base case is whether I found an empty spot in the tree
        if (current == null)
        {
            return new Node(key, value);
        }

        //determine which direction to traverse down the tree
        int compare = key.compareTo(current.key);
        if (compare == 0) //a == b
        {
            //key is already present, update the value
            current.value = value;
        }
        else if (compare < 0) // a < b
        {
            //traverse down the tree, looking to left
            current.left = add(current.left, key, value);
        }
        else //a > b
        {
            //traverse down the tree, looking to right
            current.right = add(current.right, key, value);
        }
        return current;
    }

    private class Node
    {
        //data in the node
        private Comparable key;
        private Object value;

        //child nodes
        private Node left, right;

        public Node(Comparable key, Object value)
        {
            this.key = key;
            this.value = value;
        }
    }
}

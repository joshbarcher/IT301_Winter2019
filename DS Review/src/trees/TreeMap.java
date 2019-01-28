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

    public Object get(Comparable key)
    {
        return get(root, key);
    }

    private Object get(Node current, Comparable key)
    {
        //base case, the spot where the key should be is missing
        if (current == null)
        {
            return null;
        }

        //otherwise we search down the tree
        int compare = key.compareTo(current.key);
        if (compare == 0)
        {
            return current.value; //we found it, return the value
        }
        else if (compare < 0)
        {
            return get(current.left, key);
        }
        else //compare > 0
        {
            return get(current.right, key);
        }
    }

    public Comparable findMin()
    {
        if (root == null)
        {
            return null;
        }
        return findMin(root);
    }

    private Comparable findMin(Node current)
    {
        if (current.left == null)
        {
            return current.key;
        }
        return findMin(current.left);
    }

    public Comparable findMax()
    {
        if (root == null)
        {
            return null;
        }
        return findMax(root);
    }

    private Comparable findMax(Node current)
    {
        if (current.right == null)
        {
            return current.key;
        }
        return findMin(current.right);
    }

    public int depth(Comparable search)
    {
        if (root == null)
        {
            return -1;
        }
        return depth(root, search, 0);
    }

    private int depth(Node current, Comparable search, int count)
    {
        //base case!
        if (current == null)
        {
            return -1;
        }

        int compare = search.compareTo(current.key);
        if (compare == 0) //base case!
        {
            return count;
        }
        else if (compare < 0)
        {
            return depth(current.left, search, count + 1);
        }
        else //compare > 0
        {
            return depth(current.right, search, count + 1);
        }
    }

    public int height(Node current)
    {
        return -1;
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

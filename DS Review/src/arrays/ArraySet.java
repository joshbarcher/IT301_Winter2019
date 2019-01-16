package arrays;

/**
 * This class behaves like an array list, which allows
 * continuous entry of elements. Also, this class will
 * prevent duplicates.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class ArraySet
{
    private static final int RESIZE_RATE = 2;
    private static final int DEFAULT_INIT_SIZE = 10;

    private Object[] data;
    private int size;

    public ArraySet()
    {
        this.data = new Object[DEFAULT_INIT_SIZE];
    }

    //returns true if not a duplicate, otherwise false
    public boolean add(Object newElement)
    {
        //resize the array if we have ran out of space!
        checkForResize();

        //verify that this is not a duplicate!!!
        if (checkForDups(newElement))
        {
            return false;
        }

        //place my element in the next available spot
        data[size] = newElement;
        size++;
        return true;
    }

    private void checkForResize()
    {
        if (size >= data.length)
        {
            //create a new larger array
            Object[] newData = new Object[data.length * RESIZE_RATE];

            //copy my elements from the old array to the new array
            for (int i = 0; i < data.length; i++)
            {
                newData[i] = data[i];
            }

            //save the new array and toss the old array
            data = newData;
        }
    }

    private boolean checkForDups(Object newElement)
    {
        for (int i = 0; i < size; i++)
        {
            if (data[i].equals(newElement))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public void printSet()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println(data[i]);
        }
    }
}

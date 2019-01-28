package linkedlists;

import java.util.Arrays;

public class TestLL
{
    public static void main(String[] args)
    {
        //create some data
        int[] numbers = {5, 70, 15, 69, 21, 32, 45};
        SortedLL linkedList = new SortedLL();

        //add the numbers
        for (int i = 0; i < numbers.length; i++)
        {
            linkedList.add(numbers[i]);
        }

        //print them out
        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}

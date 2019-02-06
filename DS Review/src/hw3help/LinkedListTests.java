package hw3help;

import java.util.*;

import static hw3help.LinkedListProblems.Node;

/**
 * A group of informal tests that verify the methods
 * in the LinkedListProblems class.
 *
 * DO NOT ALTER THIS FILE!
 *
 * @author Josh Archer
 * @version 1.0
 */
public class LinkedListTests
{
    private static final Random RANDOM = new Random();

    /**
     * Entry point for the informal tests.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        testJoin();
        testLastK();
        testReverse();
        testPartition();
    }

    //verifies that the join() method is working correctly
    private static void testJoin()
    {
        joinInputs();
        joinPrimaryTest();
    }

    //verifies that special cases of the inputs to join() are working
    private static void joinInputs()
    {
        //one list is empty
        Node testList = generateList(range(1, 10));
        Node empty = LinkedListProblems.join(null, testList);
        checkAndPrint(verifySameLists(testList, empty),
                "given an empty list join() is not returning the other list");

        testList = generateList(shuffle(range(1, 10)));
        empty = LinkedListProblems.join(testList, null);
        checkAndPrint(verifySameLists(testList, empty),
                "given an empty list join() is not returning the other list");

        //both lists are empty
        empty = LinkedListProblems.join(null, null);
        checkAndPrint(empty == null, "join() is not returning null when given two empty lists");
    }

    //a helper method that returns true if the elements in both linked lists are the same
    private static boolean verifySameLists(Node first, Node second)
    {
        Node currentFirst = first;
        Node currentSecond = second;

        while (currentFirst != null && currentSecond != null)
        {
            if (currentFirst.getData() != currentSecond.getData())
            {
                return false;
            }
            currentFirst = currentFirst.getNext();
            currentSecond = currentSecond.getNext();
        }

        return currentFirst == null && currentSecond == null;
    }

    //this method performs a general test of the join() method with non-empty lists
    private static void joinPrimaryTest()
    {
        //input elements to merge
        int[] first = shuffle(range(1, 10));
        int[] second = shuffle(range(11, 20));

        //create a reference array to verify results
        int[] reference = new int[20];
        for (int i = 0; i < 10; i++)
        {
            reference[i] = first[i];
            reference[i + 10] = second[i];
        }

        //perform the join
        Node joined = LinkedListProblems.join(generateList(first), generateList(second));

        //verify the results
        compareAgainstReference(reference, joined, "join");
    }

    //verifies that an array and list contain the same elements
    private static void compareAgainstReference(int[] expected, Node actual, String test)
    {
        int count = 0;
        Node current = actual;
        while (current != null)
        {
            checkAndPrint(current.getData() == expected[count],
                    test + "() is not returning elements in the expected order");
            count++;
            current = current.getNext();
        }
        checkAndPrint(count == expected.length,
                test + "() does not return all elements as a single linked list");
    }

    //verifies that the reverse() method is working correctly
    private static void testReverse()
    {
        reverseInputEdgeCases();
        reversePrimaryTest();
    }

    //checks the edge cases for inputs to the reverse method
    private static void reverseInputEdgeCases()
    {
        Node reversed = LinkedListProblems.reverse(null);
        checkAndPrint(reversed == null, "reverse() should return null given an empty list");
    }

    //verifies that a list of elements is reversed after calling the reverse() method
    private static void reversePrimaryTest()
    {
        Node testList = generateList(range(1, 10));
        int[] reference = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        //reverse the list and verify
        Node reverse = LinkedListProblems.reverse(testList);
        compareAgainstReference(reference, reverse, "reverse");
    }

    //verifies that the lastK() method is working correctly
    private static void testLastK()
    {
        lastKInputEdgeCases();
        lastKPrimaryTest();
        lastKEdgeCases();
    }

    //verifies that specific input cases are handled correctly by the lastK() method
    private static void lastKInputEdgeCases()
    {
        Node empty = LinkedListProblems.lastK(null, 10);
        checkAndPrint(empty == null, "lastK() should return null given an empty list");

        empty = LinkedListProblems.lastK(generateList(range(1, 10)), 0);
        checkAndPrint(empty == null, "lastK() should return null given k <= 0");

        empty = LinkedListProblems.lastK(generateList(range(1, 10)), -5);
        checkAndPrint(empty == null, "lastK() should return null given k <= 0");
    }

    //verifies that a list of elements can be handed to the lastK() method and the last
    //K elements are returned
    private static void lastKPrimaryTest()
    {
        Node list = generateList(range(1, 10));
        int[] reference = range(7, 10);

        //get the last k and verify
        Node lastK = LinkedListProblems.lastK(list, 4);
        compareAgainstReference(reference, lastK, "lastK");
    }

    //handles a few edge cases where k >= list size
    private static void lastKEdgeCases()
    {
        int[] reference = shuffle(range(1, 10));
        Node list = generateList(reference);

        //case k == list size
        Node lastK = LinkedListProblems.lastK(list, 10);
        compareAgainstReference(reference, lastK, "lastK");

        //case k > list size
        lastK = LinkedListProblems.lastK(list, 12);
        compareAgainstReference(reference, lastK, "lastK");
    }

    //verifies that the partition() method is working correctly
    private static void testPartition()
    {
        partitionInputs();
        partitionPrimaryTest();
    }

    //verifies that certain edge cases with inputs are handled correctly
    private static void partitionInputs()
    {
        //edge case - empty list
        Node empty = LinkedListProblems.partition(null, 10);
        checkAndPrint(empty == null, "partition() should return null given an empty list");

        //edge case - a single element
        Node testNode = new Node(1);
        Node singleElement = LinkedListProblems.partition(testNode, 10);
        checkAndPrint(singleElement != null &&
                        singleElement.getData() == 1 &&
                        singleElement.getNext() == null,
                "partition() should return a single node when given a single node");
    }

    //verifies that the partition() method can partition a random list of 10 elements
    private static void partitionPrimaryTest()
    {
        Node list = generateList(shuffle(range(1, 10)));
        Node partition = LinkedListProblems.partition(list, 5);

        Set<Integer> firstElements = new TreeSet<>();
        Set<Integer> secondElements = new TreeSet<>();
        int count = 0;
        Node current = partition;

        //pull out the first five elements - should be from the unordered set {1, 2, 3, 4, 5}
        while (current != null)
        {
            if (count < 5)
            {
                firstElements.add(current.getData());
            }
            else
            {
                secondElements.add(current.getData());
            }

            count++;
            current = current.getNext();
        }
        verifySets(firstElements, secondElements);
    }

    //verifies that two the two input sets are a partition of the elements {1, 2, 3, ... , 9, 10}
    private static void verifySets(Set<Integer> firstElements, Set<Integer> secondElements)
    {
        //verify that we have 5 elements and the elements are {1, 2, 3, 4, 5}
        checkAndPrint(firstElements.size() == 5, "partition() is not returning all 10 elements");
        checkAndPrint(secondElements.size() == 5, "partition() is not returning all 10 elements");

        for (int i = 1; i <= 10; i++)
        {
            if (i <= 5)
            {
                checkAndPrint(firstElements.contains(i),
                        "partition() is not returning elements partitioned around a value x");
            }
            else
            {
                checkAndPrint(secondElements.contains(i),
                        "partition() is not returning elements partitioned around a value x");
            }
        }
    }

    //helper methods ****************************************************

    //checks a condition and prints an output message if true
    private static void checkAndPrint(boolean condition, String output)
    {
        if (!condition)
        {
            System.out.println(output);
        }
    }

    //creates a new singly linked list based on the input elements
    private static Node generateList(int... elements)
    {
        //edge case
        if (elements.length == 0)
        {
            return null;
        }

        //create a first node
        Node current = new Node(elements[elements.length - 1]);

        //insert all other nodes at the start of the linked list
        for (int i = elements.length - 2; i >= 0; i--)
        {
            Node next = new Node(elements[i]);
            next.setNext(current);
            current = next;
        }

        //return the first element
        return current;
    }

    //returns a range of integers within the range [low,high]
    private static int[] range(int low, int high)
    {
        if (low > high)
        {
            int temp = low;
            low = high;
            high = temp;
        }

        int[] results = new int[high - low + 1];
        for (int i = 0; i < results.length; i++)
        {
            results[i] = low + i;
        }
        return results;
    }

    //randomizes the position of elements in the input array and returns a reference
    //to the same array
    private static int[] shuffle(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            swap(array, i, RANDOM.nextInt(array.length));
        }

        return array;
    }

    //swaps the position of two elements in the array
    private static void swap(int[] array, int first, int second)
    {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

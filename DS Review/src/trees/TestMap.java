package trees;

public class TestMap
{
    public static void main(String[] args)
    {
        String[] keys = {"Linda", "Sarah", "Bill", "Anna", "Calvin"};
        int[] values = {25, 22, 31, 27, 24};

        TreeMap namesToAges = new TreeMap();

        //enter our key/values
        for (int i = 0; i < keys.length; i++)
        {
            namesToAges.add(keys[i], values[i]);
        }

        //test that I can find values using keys
        System.out.println(namesToAges.get("Anna"));
        System.out.println(namesToAges.get("Bill"));
        System.out.println(namesToAges.get("Sarah"));
        System.out.println(namesToAges.get("Todd"));
        System.out.println();

        //test findMin()
        System.out.println(namesToAges.findMin());
        System.out.println(namesToAges.findMax());

        //test depth()
        System.out.println("Anna: " + namesToAges.depth("Anna"));
        System.out.println("Bill: " + namesToAges.depth("Bill"));
        System.out.println("Sarah: " + namesToAges.depth("Sarah"));
        System.out.println("Todd: " + namesToAges.depth("Todd"));
    }
}

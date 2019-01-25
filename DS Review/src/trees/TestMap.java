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
    }
}

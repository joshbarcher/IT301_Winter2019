package arrays;

public class TestSet
{
    public static void main(String[] args)
    {
        int[] elements = {15, 9, 3, 4, 7, 11, 12, 18, 1, 8, 9, 18, 10, 3, 17};
        ArraySet set = new ArraySet();

        for (int element : elements)
        {
            set.add(element);
        }

        set.printSet();

        for (int i = 1; i <= 1000000; i++)
        {
            set.add(i);
        }
        set.printSet();
    }
}

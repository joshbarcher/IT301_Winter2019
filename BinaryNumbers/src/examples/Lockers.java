package examples;

public class Lockers
{
    public static void main(String[] args)
    {
        final int NUM_LOCKERS = 50;

        BitArray lockers = new BitArray();
        for (int i = 1; i <= 50; i++) //multiples
        {
            for (int j = i - 1; j < NUM_LOCKERS; j += i) //select all multiples of i
            {
                lockers.toggle(j);
            }
        }
        lockers.printBitArray();
    }
}

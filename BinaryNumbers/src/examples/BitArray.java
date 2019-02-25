package examples;

public class BitArray
{
    private static final int MAX_INDEX = 63;
    private long flags;

    public BitArray()
    {
        //do nothing...
    }

    public void setBit(int index, boolean value)
    {
        long mask = 1L << index;

        if (value) //set bit to 1
        {
            flags = flags | mask;
        }
        else //set bit to 0
        {
            flags = flags & ~mask; //invert the mask
        }
    }

    public boolean getBit(int index)
    {
        long mask = 1L << index;

        return (flags & mask) != 0;
    }

    public void toggle(int index)
    {
        setBit(index, !getBit(index));
    }

    public void printBitArray()
    {
        for (int i = MAX_INDEX; i >= 0; i--)
        {
            System.out.print(getBit(i) ? "1" : "0");
        }
        System.out.println();
    }
}

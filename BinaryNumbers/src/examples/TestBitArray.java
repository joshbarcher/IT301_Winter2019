package examples;

public class TestBitArray
{
    public static void main(String[] args)
    {
        BitArray bits = new BitArray();

        int[] indices = {22, 18, 42, 35, 12};
        for (int i = 0; i < indices.length; i++)
        {
            bits.setBit(indices[i], true);
        }

        //test a few values
        System.out.println("0: " + bits.getBit(0));
        System.out.println("12: " + bits.getBit(12));
        System.out.println("18: " + bits.getBit(18));
        System.out.println("21: " + bits.getBit(21));
        System.out.println();

        bits.printBitArray();
    }
}

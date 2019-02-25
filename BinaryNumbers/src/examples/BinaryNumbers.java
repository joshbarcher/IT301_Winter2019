package examples;

public class BinaryNumbers
{
    public static void main(String[] args)
    {
        int redMask = 4;
        int purpleMask = 2;
        int greenMask = 1;

        String[] colors = {"red", "purple", "green", "blue", "pink", "orange",
                           "hot-pink", "black", "white", "gray", "beige", "maroon",
                           "turquoise", "light-gray", "brown",
                "red", "purple", "green", "blue", "pink", "orange",
                "hot-pink", "black", "white", "gray", "beige", "maroon",
                "turquoise", "light-gray", "brown"};

        //enumerate all subsets of three elements
        for (int i = 0; i < 1 << colors.length; i++)
        {
            //loop over all colors
            for (int j = 0; j < colors.length; j++)
            {
                int mask = 1 << j;

                if ((i & mask) != 0)
                {
                    System.out.print(colors[j] + " ");
                }
            }
            System.out.println();
        }
    }
}

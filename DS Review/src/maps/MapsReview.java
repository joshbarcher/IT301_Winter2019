package maps;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsReview
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> namesToAges = new HashMap<>();

        //add key/value pairs
        namesToAges.put("Daisy", 50);
        namesToAges.put("Bob", 20);
        namesToAges.put("Jose", 30);

        //you can give a key to get a value...
        System.out.println(namesToAges.get("Daisy"));

        //remove or clear elements
        //namesToAges.clear();

        //iterate over all keys, values or pairs
        for (String key : namesToAges.keySet())
        {
            System.out.println(key);
        }

        for (int value : namesToAges.values())
        {
            System.out.println(value);
        }

        for (String key : namesToAges.keySet())
        {
            System.out.println(key + " -> " + namesToAges.get(key));
        }
    }
}

package lab04;

import java.util.HashMap;

public class HashDictionary {
    public static class Main {
        public static void main(String[] args) {
            //KEY AND VALUE OF STRING TYPE
            HashMap<String, String> map = new HashMap<>();

            //ADD ELEMENTS
            map.put("girl", "a female human child or young woman");
            map.put("boy", " a male human child or young man");

            //DISPLAY KEYS
            System.out.println("Keys: " + map.keySet());
            //DISPLAY VALUES
            System.out.println("Values: " + map.values());
            //PRINT DICTIONARY
            System.out.println("Dictionary: " + map.entrySet());
        }
    }
}

package lab04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class FrequencyHashMap {
    public static void main(String[] args) {

        String filePath = "test.txt";

        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                //SPLIT WORDS
                String[] words = line.split("\\s+");

                //ITERATE THROUGH EACH WORD
                for (String word : words) {
                    map.merge(word, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Printing the word frequencies
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

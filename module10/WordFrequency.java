package module10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        Map<String, Integer> wordFrequency = new HashMap<>();
        try (InputStream fis = new FileInputStream("Word.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] arrLine = line.split("\\s+");

                for (String word : arrLine) {
                    if(wordFrequency.containsKey(word)) {
                        int counter = wordFrequency.get(word);
                        counter++;
                        wordFrequency.put(word, counter);
                    } else {
                        wordFrequency.put(word, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(wordFrequency);


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordFrequency.get(o2).compareTo(wordFrequency.get(o1)) > 0 ? 1: -1;
            }
        };

        Map<String, Integer> result = new TreeMap<>(comparator);
        result.putAll(wordFrequency);

        System.out.println(result);
    }
}

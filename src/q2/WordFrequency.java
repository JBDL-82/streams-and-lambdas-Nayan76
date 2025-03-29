package q2;

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public static Map<String, Long> countFrequency(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        System.out.println("Enter words (type 'done' when finished):");
        while (true) {
            String word = sc.nextLine();
            if (word.equalsIgnoreCase("done")) break;
            words.add(word);
        }

        Map<String, Long> frequencyMap = countFrequency(words);
        System.out.println("\nWord frequencies:");
        frequencyMap.forEach((word, count) ->
                System.out.println(word + ": " + count)
        );
    }
}

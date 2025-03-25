import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static Map<String, Long> countWordFrequency(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple");
        Map<String, Long> frequencyMap = countWordFrequency(words);

        System.out.println(frequencyMap); // Output: {apple=2, banana=1}
    }
}

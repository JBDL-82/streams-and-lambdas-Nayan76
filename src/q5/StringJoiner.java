package q5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJoiner {
    public static String joinWithComma(List<String> strings) {
        return strings.stream()
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter strings to join (type 'done' when finished):");

        // Using Stream.generate() to create an infinite stream of inputs
        List<String> strings = Stream.generate(sc::nextLine)
                .takeWhile(input -> !input.equalsIgnoreCase("done"))
                .collect(Collectors.toList());

        String result = joinWithComma(strings);
        System.out.println("\nJoined result:");
        System.out.println(result);
    }
}
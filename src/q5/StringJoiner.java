package q5;

import java.util.*;
import java.util.stream.Collectors;

public class StringJoiner {
    public static String joinWithComma(List<String> strings) {
        return strings.stream()
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Enter strings to join (type 'done' when finished):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            strings.add(input);
        }

        String result = joinWithComma(strings);
        System.out.println("\nJoined result:");
        System.out.println(result);
    }
}
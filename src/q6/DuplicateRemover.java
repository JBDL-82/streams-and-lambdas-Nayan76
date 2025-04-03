package q6;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateRemover {
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'done' when finished):");
        while (sc.hasNextInt()) {
            numbers.add(sc.nextInt());
        }
        sc.nextLine(); // Clear buffer

        List<Integer> unique = removeDuplicates(numbers);
        System.out.println("Unique numbers: " + unique);
    }
}

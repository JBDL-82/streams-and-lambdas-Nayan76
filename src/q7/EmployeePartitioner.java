package q7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    private String name;
    private int experience;

    public Employee(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public int getExperience() { return experience; }
    public String getName() { return name; }
}

public class EmployeePartitioner {
    public static Map<Boolean, List<Employee>> partitionByExperience(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getExperience() >= 5));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of employees:");
        int n = sc.nextInt();
        sc.nextLine();

        List<Employee> employees = IntStream.range(0, n)
                .mapToObj(i -> {
                    System.out.println("Enter employee " + (i+1) + " name:");
                    String name = sc.nextLine();
                    System.out.println("Enter employee " + (i+1) + " experience (years):");
                    int experience = sc.nextInt();
                    sc.nextLine();
                    return new Employee(name, experience);
                })
                .collect(Collectors.toList());

        Map<Boolean, List<Employee>> partitioned = partitionByExperience(employees);

        System.out.println("\nExperienced employees (5+ years):");
        partitioned.getOrDefault(true, Collections.emptyList())
                .stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("\nLess experienced employees:");
        partitioned.getOrDefault(false, Collections.emptyList())
                .stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}

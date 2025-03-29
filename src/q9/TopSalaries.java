package q9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() { return salary; }
    public String getName() { return name; }
}
public class TopSalaries {
    public static List<String> topThreeSalaries(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toList());
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
                    System.out.println("Enter employee " + (i+1) + " salary:");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    return new Employee(name, salary);
                })
                .collect(Collectors.toList());

        List<String> topEarners = topThreeSalaries(employees);
        System.out.println("\nTop 3 earners:");

        // Using Stream to print instead of traditional for-loop
        IntStream.range(0, topEarners.size())
                .forEach(i -> System.out.println((i+1) + ". " + topEarners.get(i)));
    }
}


package q1;

import java.util.*;
import java.util.stream.*;

class Employees {
    private String name;
    private double salary;

    public Employees(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() { return salary; }
    public String getName() { return name; }
}
public class EmployeesSalaryFilter {
    public static List<Employees> filterBySalary(List<Employees> employeesList, double threshold) {
        return employeesList.stream()
                .filter(emp -> emp.getSalary() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employees data (type 'done' when finished):");
        System.out.println("Format: Name,Salary (e.g. John,75000)");

        List<Employees> employeesList = Stream.generate(() -> {
                    System.out.print("> ");
                    return sc.nextLine();
                })
                .takeWhile(input -> !input.equalsIgnoreCase("done"))
                .filter(input -> input.contains(","))
                .map(input -> {
                    String[] parts = input.split(",");
                    return new Employees(parts[0].trim(), Double.parseDouble(parts[1].trim()));
                })
                .collect(Collectors.toList());

        List<Employees> highEarners = filterBySalary(employeesList, 50000);

        // Display results
        System.out.println("\nEmployees earning more than 50,000:");
        highEarners.stream()
                .sorted(Comparator.comparingDouble(Employees::getSalary).reversed())
                .forEach(emp -> System.out.printf("%s: $%,.2f%n", emp.getName(), emp.getSalary()));

        if (highEarners.isEmpty()) {
            System.out.println("No employees found earning above 50,000");
        }
    }
}

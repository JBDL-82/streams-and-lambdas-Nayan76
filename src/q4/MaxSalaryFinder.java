package q4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

public class MaxSalaryFinder {
    public static Optional<Employee> findMaxSalaryEmployee(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee data (type 'done' when finished):");
        System.out.println("Format: Name,Salary (e.g. John,75000)");

        List<Employee> employees = Stream.generate(() -> {
                    System.out.print("> ");
                    return sc.nextLine();
                })
                .takeWhile(input -> !input.equalsIgnoreCase("done"))
                .filter(input -> input.contains(","))
                .map(input -> {
                    String[] parts = input.split(",");
                    return new Employee(parts[0].trim(),
                            Double.parseDouble(parts[1].trim()));
                })
                .collect(Collectors.toList());

        Optional<Employee> maxEmployee = findMaxSalaryEmployee(employees);

        System.out.println("\nResult:");
        maxEmployee.ifPresentOrElse(
                emp -> System.out.printf("Highest paid employee: %s ($%,.2f)%n",
                        emp.getName(), emp.getSalary()),
                () -> System.out.println("No employees entered")
        );
    }
}

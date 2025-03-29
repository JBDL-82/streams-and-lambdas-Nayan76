package q8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getName() { return name; }
}

public class DepartmentAverages {
    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
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
                    System.out.println("Enter employee " + (i+1) + " department:");
                    String dept = sc.nextLine();
                    System.out.println("Enter employee " + (i+1) + " salary:");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    return new Employee(name, dept, salary);
                })
                .collect(Collectors.toList());

        Map<String, Double> averages = averageSalaryByDepartment(employees);
        System.out.println("\nAverage salaries by department:");

        // Using Stream for output
        averages.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue())
                );
    }
}

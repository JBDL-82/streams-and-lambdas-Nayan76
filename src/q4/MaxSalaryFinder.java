package q4;

import java.util.*;

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
        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter number of employees:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter employee " + (i+1) + " name:");
            String name = sc.nextLine();
            System.out.println("Enter employee " + (i+1) + " salary:");
            double salary = sc.nextDouble();
            sc.nextLine();
            employees.add(new Employee(name, salary));
        }

        Optional<Employee> maxEmployee = findMaxSalaryEmployee(employees);
        maxEmployee.ifPresentOrElse(
                e -> System.out.println("Highest paid employee: " + e.getName() + " ($" + e.getSalary() + ")"),
                () -> System.out.println("No employees found")
        );
    }
}

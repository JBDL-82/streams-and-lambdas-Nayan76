import java.util.*;
import java.util.stream.Collectors;

public class EmployeeFilter {
    public static List<Employee> filterBySalary(List<Employee> employees, double threshold) {
        return employees.stream()
                .filter(e -> e.getSalary() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter number of employees:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter employee " + (i+1) + " name:");
            String name = sc.nextLine();
            System.out.println("Enter employee " + (i+1) + " salary:");
            double salary = sc.nextDouble();
            sc.nextLine(); // consume newline
            employees.add(new Employee(name, salary));
        }

        System.out.println("Enter salary you want find higher:");
        double threshold = sc.nextDouble();

        List<Employee> result = filterBySalary(employees, threshold);
        System.out.println("\nEmployees earning above " + threshold + ":");
        result.forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));
    }
}

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
package q3;


import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() { return department; }
    public String getName() { return name; }
}

public class EmployeeGrouper {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
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
            System.out.println("Enter employee " + (i+1) + " department:");
            String dept = sc.nextLine();
            employees.add(new Employee(name, dept));
        }

        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        System.out.println("\nEmployees by department:");
        grouped.forEach((dept, emps) -> {
            System.out.println(dept + ":");
            emps.forEach(e -> System.out.println("  " + e.getName()));
        });
    }
}

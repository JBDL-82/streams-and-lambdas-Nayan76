package q3;


import java.util.*;
import java.util.stream.*;

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
    public static Map<String, List<String>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of employees:");
        int employeeCount = Integer.parseInt(sc.nextLine());

        List<Employee> employees = IntStream.range(0, employeeCount)
                .mapToObj(i -> {
                    System.out.println("Enter employee " + (i+1) + " name:");
                    String name = sc.nextLine();
                    System.out.println("Enter employee " + (i+1) + " department:");
                    String department = sc.nextLine();
                    return new Employee(name, department);
                })
                .collect(Collectors.toList());

        Map<String, List<String>> departmentGroups = groupByDepartment(employees);

        System.out.println("\nEmployees grouped by department:");
        departmentGroups.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println("\n" + entry.getKey() + ":");
                    entry.getValue().stream()
                            .sorted()
                            .forEach(name -> System.out.println(" - " + name));
                });
    }
}

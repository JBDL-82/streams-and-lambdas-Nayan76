package q11;

import java.util.*;
import java.util.stream.*;

class Employees {
    private String name;
    private String department;

    public Employees(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
}


public class DepartmentAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get all departments
        System.out.println("Enter department names (comma separated):");
        List<String> departments = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        // Get employees
        System.out.println("\nEnter employees (Name,Department). Type 'done' to finish:");
        List<Employees> employees = Stream.generate(() -> {
                    System.out.print("> ");
                    return sc.nextLine();
                })
                .takeWhile(line -> !line.equalsIgnoreCase("done"))
                .filter(line -> line.contains(","))
                .map(line -> {
                    String[] parts = line.split(",");
                    return new Employees(parts[0].trim(), parts[1].trim());
                })
                .collect(Collectors.toList());

        // Group employees by department
        Map<String, List<Employees>> deptMap = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment));

        // Show results
        System.out.println("\nDepartment Report:");
        departments.forEach(dept -> {
            System.out.println("\n" + dept + ":");
            if (deptMap.containsKey(dept)) {
                deptMap.get(dept).stream()
                        .map(Employees::getName)
                        .sorted()
                        .forEach(name -> System.out.println(" - " + name));
            } else {
                System.out.println(" - No employees");
            }
        });

        // Show empty departments summary
        List<String> emptyDepts = departments.stream()
                .filter(dept -> !deptMap.containsKey(dept))
                .collect(Collectors.toList());

        System.out.println("\nEmpty Departments:");
        emptyDepts.forEach(System.out::println);
    }
}

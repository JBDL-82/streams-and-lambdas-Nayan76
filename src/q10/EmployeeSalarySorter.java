package q10;

import java.util.*;
import java.util.stream.*;

class Employees{
    private String name;
    private double salary;

    public Employees(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public double getSalary(){ return salary; }
    public String getName(){ return name; }
}

public class EmployeeSalarySorter {
    public static List<Employees> sortBySalaryDescending(List<Employees> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employees::getSalary).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee data (type 'done' when finished): ");
        System.out.println("Format Name, Salary (e.g. John, 75000");

        List<Employees> employees = Stream.generate(() -> {
            System.out.print("> ");
            return sc.nextLine();
        })
                .takeWhile(input -> !input.equalsIgnoreCase("done"))
                .filter(input -> input.contains(","))
                .map(input -> {
                    String[] parts = input.split(",");
                    return new Employees(parts[0], Double.parseDouble(parts[1].trim()));
                })
                .collect(Collectors.toList());

        List<Employees> sortedEmployees = sortBySalaryDescending(employees);

        System.out.println("\nEmployees sorted by Salary (highest to lowest):");
        sortedEmployees.forEach(emp ->
                System.out.printf("%s: $%, .2f%n", emp.getName(), emp.getSalary()));

        if (sortedEmployees.isEmpty()) {
            System.out.println("No employees found");
        }
    }
}

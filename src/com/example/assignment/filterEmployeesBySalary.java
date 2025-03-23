import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    String name;
    double salary;

    // Constructor to easily Create Employee objects
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Override toString() so employees can be printed in a readable way
    @Override
    public String toString() {
        return String.format("Employee: %s, Salary: %.2f", name, salary);
    }
}

public class filterEmployeesBySalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of employees:");
        int numEmployees = sc.nextInt();

        // Creating a list of employees
        List<Employee> employees = IntStream.range(0, numEmployees)
                .mapToObj(i -> {
                    System.out.println("Enter employee name:" + (i + 1) + ":");
                    System.out.print("Enter employee Name: ");
                    String name = sc.next();
                    System.out.print("Enter employee Salary: ");
                    double salary = sc.nextDouble();
                    return new Employee(name, salary);
                })
                .collect(Collectors.toList());

        // Use streams to filter employees with salary greater than 50,000
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employee.salary > 50000)
                .collect(Collectors.toList());

        // Print the Employees
        System.out.println("The employees earning more than 50,000: ");
        filteredEmployees.forEach(employee -> System.out.println(employee));

        sc.close();
    }
}
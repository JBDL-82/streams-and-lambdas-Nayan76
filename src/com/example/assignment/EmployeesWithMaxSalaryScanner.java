import java.util.*;
import java.util.stream.IntStream;

class Employees {
    String name;
    String department;
    double salary;

    public Employees(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class EmployeesWithMaxSalaryScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employees> employees = new ArrayList<>();

        System.out.println("Enter the number of employees: ");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine();

        IntStream.range(0, numberOfEmployees)
                .forEach(i -> {
                    System.out.println("Enter details for employee " + (i+1) + ":");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    employees.add(new Employees(name, department, salary));
                });

        // Find the employee with the maximum salary using streams
        Optional<Employees> employeesWithMaxSalary = employees.stream()
                .max(Comparator.comparingDouble(Employees::getSalary));

        // Print the result
        if (employeesWithMaxSalary.isPresent()) {
            System.out.println("\nEmployee with the highest salary: " + employeesWithMaxSalary.get());
        } else {
            System.out.println("\nThe list of employees is empty.");
        }

        scanner.close();
    }
}

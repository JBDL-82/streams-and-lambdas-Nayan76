import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DepartmentEmployee{
    String name;
    String department;

    public DepartmentEmployee(String name, String department){
        this.name = name;
        this.department = department;
    }

    public String getName(){
        return name;
    }

    public String getDepartment(){
        return department;
    }

    @Override
    public String toString(){
        return "DepartmentEmployee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
public class groupEmployeesByDepartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<DepartmentEmployee> employees = new ArrayList<>();

        System.out.println("Enter the numbers of employees: ");
        int numberOfEmployees = sc.nextInt();
        sc.nextLine();

        IntStream.range(0, numberOfEmployees)
                .forEach(i -> {
                    System.out.println("\nEnter details for employee " + (i + 1) + ": ");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter department: ");
                    String department = sc.nextLine();
                    employees.add(new DepartmentEmployee(name, department));
                });

        //Group employee by department using streams
        Map<String, List<DepartmentEmployee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(DepartmentEmployee::getDepartment));

        //Print the grouped employees
        employeesByDepartment.forEach((department, employeeList) -> {
            System.out.println("\nDepartment: " + department);
            employeeList.forEach(System.out::println);
        });

        sc.close();
    }

}
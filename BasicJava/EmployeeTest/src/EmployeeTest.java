import java.time.LocalDate;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 7500, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 5000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // raise everyone's salary by 5%
        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        // print out information about all Employees
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireday());
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private LocalDate hireday;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireday = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireday() {
        return hireday;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

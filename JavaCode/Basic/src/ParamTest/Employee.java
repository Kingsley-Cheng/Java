package ParamTest;

// simplified ParamTest.Employee class
public class Employee {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        this.name = n;
        this.salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}

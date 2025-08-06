class Employee {
    private static int nextId = 1; // static variable

    private String name;
    private double salary;
    private int id; //Employee ID, unique

    public Employee(String n, double s) {
        this.name = n;
        this.salary = s;
        this.id = 0;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void main(String[] args) {
        var e = new Employee("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }
}

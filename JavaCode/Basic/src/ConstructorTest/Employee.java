package ConstructorTest;

import java.util.Random;

class Employee {
    private static int nextId;

    // static initialization block
    static {
        var generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    private int id;
    private String name = ""; // instance field initialization
    private double salary;

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    // three overload constructors
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        // calls the ConstructorTest.Employee(String, double) constructor
        this("ConstructorTest.Employee #" + nextId, s);
    }

    // the default constructor
    public Employee() {
        // name initialized to ""
        // salary initialized to 0
        // id initialized in initialization block
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
}

package ConstructorTest;/*
 * 重载构造器
 * 用this(...)调用另一个构造器
 * 无参数构造器
 * 对象初始化块
 * 静态初始化块
 * 实例字段初始化
 */

public class ConstructorTest {
    public static void main(String[] args) {
        // fill the staff arry with three Employee objects
        var staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
        }
    }
}
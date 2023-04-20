package fc.java.part4;

public class Employee {
    private String name;
    private int age;
    private String phone;
    private String empDate;
    private String dept;
    private boolean marriage;

    public Employee(){
    }

    public Employee(String name, int age, String phone, String empDate, String dept, boolean marriage){
        this.name = name;
        this.age = age;
        this.empDate = empDate;
        this.dept = dept;
        this.phone = phone;
        this.marriage = marriage;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", empDate='" + empDate + '\'' +
                ", dept='" + dept + '\'' +
                ", marriage=" + marriage +
                '}';
    }
}

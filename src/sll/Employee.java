package sll;

public class Employee {
    private String code = "", name = "";
    private int salary = 0;

    public Employee(){

    }
    public Employee(String code, String name, int salary) {
        this.code = code;
        this.name = name;
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    //Matching 2 employees object
    public boolean equals (Employee emp){
        return emp.getCode().equals(this.getCode()) &&
                emp.getName().equals(this.getName()) &&
                emp.getSalary() == this.getSalary();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

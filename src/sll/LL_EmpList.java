package sll;

import java.util.Scanner;

public class LL_EmpList extends SLL {
    Scanner sc = null;
    public LL_EmpList(){
        super(); //call father's constructor class
        sc = new Scanner(System.in);
    }
    //Find an employee with a know code - Linear Search - Validation
    private SLLNode<Employee> find (String code){
        SLLNode<Employee> ref;
        for(ref = this.getHead(); ref != null; ref = ref.next)
            if(ref.info.getCode().equals(code))
                return ref;
            return null;
    }
    //Add an employee to the end of the list
    public void add(){
        String code = "", name = ""; int salary = 0;
        System.out.println("Add new employee: ");
        boolean proceed = false;
        //enter code
        do{
            System.out.println("Enter employee's code: ");
            code = sc.nextLine().toUpperCase();
            proceed = find(code) != null; //duplicate code
            if(proceed){
                System.out.println("This code is duplicated!");
            }
        }while(proceed);
        //enter name
        do{
            System.out.println("Enter employee's name: ");
            name = sc.nextLine().trim();
            proceed = (name.length() == 0);
            if(proceed){
                System.out.println("Employee's name must be inputted.");
            }
        }while(proceed);
        //enter salary
        do{
            System.out.println("Enter employee's salary: ");
            salary = Integer.parseInt(sc.nextLine());
            if(salary <= 0){
                System.out.println("Employee's salary must be greater than 0.");
            }
        }while(salary <= 0);
        //Add this employee to the end of the list
        Employee emp = new Employee(code, name, salary);
        this.addToTail(emp);
        System.out.println("This employee is added.");
    }
    //Remove an employee
    public void remove(){
        if(this.isEmpty()) {
            System.out.println("List is empty.");
        }else{
            String code = "";
            System.out.println("Enter employee's code to remove: ");
            code = sc.nextLine().toUpperCase();
            SLLNode<Employee> ref = find(code);
            if(ref == null){
                System.out.println("He/she does not exist.");
            }else{
                this.delete(ref.info);
                System.out.println("This employee has been removed.");
            }
        }
    }
    //Increasing the salary of an employee
    public void increaseSalary(){
        if(this.isEmpty()){
            System.out.println("List is empty.");
        }else {
            String code = "";
            System.out.println("Enter employee's code who will be promoted: ");
            code = sc.nextLine().toUpperCase();
            SLLNode<Employee> ref = find(code);
            if(ref == null){
                System.out.println("He/she does not exist.");
            }else{
                int oldSal = ref.info.getSalary();
                int newSal;
                do{
                    System.out.println("Old salary: " + oldSal + ", new salary: ");
                    newSal = Integer.parseInt(sc.nextLine());
                }while (newSal <= oldSal);
                ref.info.setSalary(newSal);
                System.out.println("Employee's new salary has been updated.");
            }

        }
    }
    //Remove an employee from tail
    public SLL<Employee> deleteLastEmpl() {
        SLL<Employee> tmp = null;
        if (this.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("This employee has been removed.");
            tmp = (SLL<Employee>) this.deleteFromTail();
        }
    return tmp;
    }

    //print
    public void print(){
        if(this.isEmpty()){
            System.out.println("The list is empty.");
        }else{
            System.out.println("EMPLOYEE LIST: ");
            this.printAll();
        }
    }
}

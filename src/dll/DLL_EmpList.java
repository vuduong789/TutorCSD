package dll;

import sll.Employee;

import java.util.Scanner;

public class DLL_EmpList extends DLL {
    Scanner sc = null;
    public DLL_EmpList(){
        super(); //call father's constructor class
        sc = new Scanner(System.in);
    }


    //TODO
    //Find an employee with a know code - Linear Search - Validation
    private DLLNode<Employee> find (String code){
        DLLNode<Employee> ref;

        return null;
    }
    //Add an employee to the end of the list
    public void add(){

    }
    //Remove an employee
    public void remove(){
        if(this.isEmpty()) {
            System.out.println("List is empty.");
        }else{

        }
    }
    //Increasing the salary of an employee
    public void increaseSalary(){
        if(this.isEmpty()){
            System.out.println("List is empty.");
        }else {


        }
    }
    //Remove an employee from tail
    public DLL<Employee> deleteLastEmpl() {
        DLL<Employee> tmp = null;

        return tmp;
    }

    //print
    public void print(){
        if(this.isEmpty()){
            System.out.println("The list is empty.");
        }else{
            System.out.println("EMPLOYEE LIST: ");
            this.print();
        }
    }
}

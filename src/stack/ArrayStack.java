package stack;

import sll.Employee;

import java.util.EmptyStackException;

public class ArrayStack {
    protected Object [] a;
    int top, max;

    public ArrayStack(){
    }

    public ArrayStack(int max){
        this.max = max;
        a = new Object[max];
        top = -1;
    }
    protected  boolean grow(){
        int max1 = max + max/2;
        Object [] a1 = new Object[max1];
        if(a1 == null) return(false);
        for(int i = 0; i <= top; i++) a1[i] = a[i];
        a = a1;
        return(true);
    }

    public boolean isEmpty(){
        return(top==-1);
    }

    public boolean isFull(){
        return(top==max-1);
    }

    public void clear(){
        top=-1;
    }

    public void push(Object x){
        if(isFull() && !grow())
            return;
        a[++top] = x;
    }

    Object top() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        return(a[top]);
    }

    public Object pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        Object x = a[top];
        top--;
        return(x);
    }

    public static void main(String[] args) {
        ArrayStack demoStack = new ArrayStack(3);
        demoStack.grow();
        demoStack.push(new Employee("01", "Duong", 2000));
        System.out.println(demoStack.isEmpty());
        demoStack.push(new Employee("02", "Bla", 22));
        demoStack.push(1);
        demoStack.push(2);
        System.out.println(demoStack.pop());
        System.out.println(demoStack.pop());
        System.out.println(demoStack.pop());
        System.out.println(demoStack.pop());

    }
}

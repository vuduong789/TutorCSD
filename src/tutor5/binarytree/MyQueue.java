package tutor5.binarytree;

import java.util.LinkedList;

public class MyQueue <E> extends LinkedList<E> {
    public MyQueue() {
        super();
    }
    //them vao cuoi hang doi
    public void enqueue (E x) {
        this.addLast(x);
    }
    public E dequeue(){
        return this.poll();
    }
}

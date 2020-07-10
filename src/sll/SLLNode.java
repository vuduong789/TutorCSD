package sll;

public class SLLNode <T>{
    T info;
    SLLNode<T> next;
    public SLLNode(){
        next = null;
    }

    public SLLNode(T el){
        info = el;
        next = null;
    }
    public SLLNode(T el, SLLNode<T> afterEl){
        info = el;
        next = afterEl;
    }
}

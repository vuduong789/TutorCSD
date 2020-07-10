package sll;

public class SLL<T> {
    protected SLLNode<T> head, tail;

    public SLL() {
        head = tail = null;
    }

    public SLLNode<T> getHead() {
        return head;
    }

    public void setHead(SLLNode<T> head) {
        this.head = head;
    }

    public SLLNode<T> getTail() {
        return tail;
    }

    public void setTail(SLLNode<T> tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(T el) {
        head = new SLLNode<T>(el, head);
        if (tail == null)
            tail = head;
    }

    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        } else
            head = tail = new SLLNode<T>(el);
    }

    public T deleteFromHead() {
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)
            head = tail = null;
        else
            head = head.next;
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)
            head = tail = null;
        else {
            SLLNode<T> tmp;
            for (tmp = head; tmp.next != tail; tmp = tmp.next) ;
            tail = tmp;
            tail.next = null;
        }
        return el;
    }

    public void delete(T el) {
        if (isEmpty())
            if (head == tail && el.equals(head.info)) //if only one
                head = tail = null; //node on the list
            else if (el.equals(head.info)) //if more than one node in list
                head = head.next; //and el is head node
            else {
                SLLNode<T> pred, tmp;
                for (pred = head, tmp = head.next; tmp != null && !(tmp.info.equals(el));
                     pred = pred.next, tmp = tmp.next)
                    ;
                if (tmp != null) {
                    pred.next = tmp.next;
                    if (tmp == tail) { //if el is the last
                        tail = pred;
                    }
                }
            }
    }

    public void printAll(){
        for(SLLNode<T> tmp = head; tmp != null; tmp = tmp.next){
            System.out.println(tmp.info);
        }
    }
    //Checking whether the el is in the list
    public boolean isInList(T el){
        SLLNode <T> tmp;
        for(tmp = head; tmp!= null && !tmp.info.equals(el); tmp = tmp.next);
        return tmp!= null;
    }
}

package dll;

public class DLLNode <E> {
    private E element;
    private DLLNode<E> prev;
    private DLLNode<E> next;

    public DLLNode (E element, DLLNode<E> prev, DLLNode<E> next){
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public DLLNode<E> getPrev() {
        return prev;
    }

    public DLLNode<E> getNext() {
        return next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setPrev(DLLNode<E> prev) {
        this.prev = prev;
    }

    public void setNext(DLLNode<E> next) {
        this.next = next;
    }

}

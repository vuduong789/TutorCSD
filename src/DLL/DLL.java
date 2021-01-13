package DLL;

public class DLL <E> {
    private DLLNode <E> header;
    private DLLNode <E> trailer;
    private int size = 0;

    public DLL(){
        header = new DLLNode<E>(null, null, null);
        trailer = new DLLNode<E>(null, header, null);
        header.setNext(trailer);
    }

    public E first() {
        if(isEmpty()) return null;
        return header.getNext().getElement(); //first element is beyond header
    }
    public E last() {
        if(isEmpty()) return null;
        return trailer.getPrev().getElement(); //last e is before trailer
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return getSize() == 0; // return size == 0;
    }
    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); //place just after the header
    }
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); //place just before the trailer
    }

    public E removeFirst() {
        if(isEmpty()) return null;
        return remove(header.getNext()); //first element is beyond header
    }
    public E removeLast() {
        if(isEmpty()) return null;
        return remove(trailer.getPrev()); //last element is before trailer
    }

    /*
     * private update method
     */

    private void addBetween(E e, DLLNode<E> predecessor, DLLNode<E> successor) {
        //create and link a new node
        DLLNode<E> newest = new DLLNode<E>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size ++;
    }
    private E remove(DLLNode<E> node) {
        DLLNode<E> predecessor = node.getPrev();
        DLLNode<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size --;
        return node.getElement();
    }

}

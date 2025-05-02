package domain.queue.Domain;

public class Node {
    public Object data;
    public Node prev; //apuntador al nodo anterior
    public Node next;//apuntador al nodo siguiente
    public int priority; // 1 = low , 2= mediada y 3 = alta

    //Constructor 1
    public Node(Object data) {
        this.data = data;
        this.prev = this.next = null; //puntero al sgte nodo es nulo por default
    }

    //Constructor 2
    public Node() {
         this.next = null;
    }

    //Constructor 3
    public Node( Object element , int priority) {

        this.data = element;
        this.next = null;
        this.priority = priority;
    }
}

package domain.queue.Domain;

import domain.stack.StackException;

public class HeaderLinkedQueue implements Queues{

    private Node front; //anterior
    private Node rear; //posterior
    private int counter; //control de elementos encolados

    //Constructor
    public HeaderLinkedQueue(){
        front=rear=new Node();
        counter=0;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        front=rear=new Node();
        counter=0;
    }

    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    @Override
    public int indexOf(Object element) throws QueueException, StackException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        HeaderLinkedQueue aux = new HeaderLinkedQueue();
        int pos1=1;
        int pos2=-1; //si es -1 no existe
        while(!isEmpty()){
            if(util.Utility.compare(front(), element)==0){
                pos2 = pos1;
            }
            aux.enQueue(deQueue());
            pos1++;
        }//while
        //al final dejamos la cola en su estado original
        while(!aux.isEmpty()){
            enQueue(aux.deQueue());
        }
        return pos2;
    }

    @Override
    public void enQueue(Object element) throws QueueException {
        Node newNode = new Node(element);
        rear.next = newNode;
        rear = newNode; //movemos rear al nodo encolado
        //al final actualizo el contador
        counter++;
    }

    @Override
    public Object deQueue() throws QueueException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        Object element = front.next.data;
        //caso 1. cuando solo hay un elemento
        //cuando estan apuntando al mismo nodo
        if(front.next==rear){
            clear(); //elimino la cola
        }else{ //caso 2. caso contrario
            front.next = front.next.next; //anterior.ste=anterior.sgte.sgte
        }
        //actualizo el contador de elementos encolados
        counter--;
        return element;
    }

    @Override
    public boolean contains(Object element) throws QueueException, StackException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        HeaderLinkedQueue aux = new HeaderLinkedQueue();
        boolean finded = false;
        while(!isEmpty()){
            if(util.Utility.compare(front(), element)==0){
                finded = true;
            }
            aux.enQueue(deQueue());
        }//while
        //al final dejamos la cola en su estado original
        while(!aux.isEmpty()){
            enQueue(aux.deQueue());
        }
        return finded;
    }

    @Override
    public Object peek() throws QueueException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        return front.next.data;
    }

    @Override
    public Object front() throws QueueException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        return front.next.data;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "Header Linked Queue is Empty";
        String result = "Header Linked Queue content\n";
        HeaderLinkedQueue aux = new HeaderLinkedQueue();
        try {
            while (!isEmpty()) {
                result += front() + "\n";
                aux.enQueue(deQueue());
            }
            //al final dejamos la cola con loas valores default
            while (!aux.isEmpty()) {
                enQueue(aux.deQueue());
            }
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

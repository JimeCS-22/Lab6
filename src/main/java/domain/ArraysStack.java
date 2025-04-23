package domain;

import java.util.Arrays;

public class ArraysStack implements Stack {

    private int n ; //The maximum stack size
    private int top;//To keep track of the stack
    private Object dataStack[];

    //Constructor


    public ArraysStack(int n) {

        if (n<=0) System.exit(1);//It comes out

        this.n= n;
        this.top = -1; //Indicates that the battery is empty
        this.dataStack = new Object[n];
    }

    @Override
    public int size() throws StackException {

        if(isEmpty()){

            throw new StackException("Satck List is empty");

        }

        return top+1;
    }

    @Override
    public void clear() {

        dataStack = new Object[n];
        top = -1;

    }

    @Override
    public boolean isEmpty() {

        return top==-1;

    }

    @Override
    public Object peek() throws StackException {

        if(isEmpty()){

            throw new StackException("Satck List is empty");

        }


        return dataStack[top];
    }

    @Override
    public Object top() throws StackException {

        if(isEmpty()){

            throw new StackException("Satck List is empty");

        }

        return dataStack[top];
    }

    @Override
    public void push(Object element) throws StackException {

        if( top >= n){

            throw new StackException("Satck List is empty");
        }

        dataStack[++top] = element;

    }

    @Override
    public Object pop() throws StackException {

        if (isEmpty()){

            throw new StackException("Stack List is empty");

        }

        return dataStack[top--];

    }

    @Override
    public String toString() {

        if (isEmpty()) return "Array Stack is Empty";

        String result = "Array Stack Content:\n";

        try {

            ArraysStack aux= new ArraysStack(size());

            while (!isEmpty()){

                result += peek() + "\n ";
                aux.push(pop());

            }
            //Deja la pila en su estado original
            while (!aux.isEmpty()){
              push(aux.pop());
            }

        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }
}

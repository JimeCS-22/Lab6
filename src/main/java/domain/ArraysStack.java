package domain;

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

        dataStack = new Object[];
        top = -1;

    }

    @Override
    public boolean isEmpty() {

        top = Integer.parseInt(null);

        return true;

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

            throw new StackException("Satck List is empty");

        }

        return dataStack[top--];

    }
}

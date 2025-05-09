package domain.stack;

public class LinkedListStack implements Stack {

    private Node top;
    private int counter;

    public LinkedListStack() {

        this.top = null;
        this.counter = 0;

    }

    @Override
    public int size() throws StackException {

        if (isEmpty()) {

            throw new StackException("Stack List is empty");

        }

        return counter;

    }

    @Override
    public void clear() {

        top = null;
        counter = 0;

    }

    @Override
    public boolean isEmpty() {

        return top == null;

    }

    @Override
    public Object peek() throws StackException {

        return top.data;
    }

    @Override
    public Object top() throws StackException {

        return top.data;
    }

    @Override
    public void push(Object element) throws StackException {

        Node newNode = new Node(element);

        if (!isEmpty()) newNode.next = top;

        top = newNode;
        counter++;

    }

    @Override
    public Object pop() throws StackException {

        if (isEmpty()) {

            throw new StackException("Stack List is empty");

        }

        Object result;
        result = top.data;

        top = top.next;
        counter--;

        return result;
    }

    public static boolean isBalanced(String expression) throws StackException {
        LinkedListStack pila = new LinkedListStack();

        for (char character : expression.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') {
                pila.push(character);
            } else if (character == ')' || character == '}' || character == ']') {
                if (pila.isEmpty()) {
                    return false;
                }
                char top = (char) pila.pop();
                if (!coinciden(top, character)) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    private static boolean coinciden(char abre, char cierra) {
        return (abre == '(' && cierra == ')') ||
                (abre == '{' && cierra == '}') ||
                (abre == '[' && cierra == ']');
    }





    @Override
    public String toString() {

        if (isEmpty()) return "Linked Stack is Empty";

        String result = "Linked Stack Content:\n";

        try {

            LinkedListStack aux = new LinkedListStack();

            while (!isEmpty()) {

                result += peek() + "\n ";
                aux.push(pop());

            }

            //Deja la pila en su estado original
            while (!aux.isEmpty()) {
                push(aux.pop());
            }

        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

}


package domain;

import org.junit.jupiter.api.Test;

import static domain.LinkedListStack.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    @Test
    void test() {

        LinkedListStack linkedListStack = new LinkedListStack();

        try {
            for (int i = 0; i < 10; i++) {

                int value = util.Utility.random(30);
                System.out.println("Value[ " + value + " ] pushed ");
                linkedListStack.push(value);

            }

            System.out.println(linkedListStack);
            System.out.println(linkedListStack);


        } catch (StackException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Test por balance:");
        try {
            System.out.println(isBalanced("({[]})"));
            System.out.println(isBalanced("([])"));
            System.out.println(isBalanced("([)]"));
            System.out.println(isBalanced("((()))"));
            System.out.println(isBalanced("{[}"));
            System.out.println(isBalanced("]"));
            System.out.println(isBalanced(""));

        } catch (StackException e) {

            throw new RuntimeException(e);

        }



    }

}
package domain;

import org.junit.jupiter.api.Test;

import static domain.LinkedListStack.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    @Test
    void test(){

        LinkedListStack linkedStack = new LinkedListStack();

        try {
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(30);
                System.out.println("Value ["+value+"} pushed");
                linkedStack.push(value);
            }

            System.out.println(linkedStack);
            System.out.println(linkedStack);//llamo de nuevo al toString

            System.out.println("Is Balanced Test:");
            System.out.println(isBalanced("({[]})"));
            System.out.println(isBalanced("([])"));
            System.out.println(isBalanced("([)]"));
            System.out.println(isBalanced("((()))"));
            System.out.println(isBalanced("{[}"));
            System.out.println(isBalanced("]"));
            System.out.println(isBalanced(""));

        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }


    }


}
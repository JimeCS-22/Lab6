package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysStackTest {

    @Test
    void test(){

        ArraysStack arraysStack = new ArraysStack(10);

        try {
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(30);
                System.out.println("Value ["+value+"} pushed");
                arraysStack.push(value);
            }

            System.out.println(arraysStack);
            System.out.println(arraysStack);//llamo de nuevo al toString


        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }



    }


}
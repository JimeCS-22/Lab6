package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysStackTest {

    @Test
    void test() {

        ArraysStack arraysStack = new ArraysStack(11);

        try {
            //Testeo con los nombres
            System.out.println("Test for arrayStack with names");
            arraysStack.push(new Person(1 , "Alanna" , 18));
            arraysStack.push(new Person(2 , "Pablo" , 20));
            arraysStack.push(new Person(3 , "Ana" , 21));
            arraysStack.push(new Person(4 , "Maria" , 20));
            arraysStack.push(new Person(5 , "Victoria" , 18));
            arraysStack.push(new Person(6 , "Nicole" , 19));
            arraysStack.push(new Person(7 , "Mateo" , 18));
            arraysStack.push(new Person(8 , "Nicole" , 23));
            arraysStack.push(new Person(9 , "Alana" , 22));
            arraysStack.push(new Person(10 , "Pablo" , 1));
            arraysStack.push(new Person(11 , "Ana" , 18));

            System.out.println(arraysStack);




        } catch (StackException ex){
            System.out.println(ex.getMessage());
        }
    }
}
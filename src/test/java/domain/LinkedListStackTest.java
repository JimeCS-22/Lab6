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

            System.out.println("Is Balanced Test");
            System.out.println("IsBalanced ({[]}) "+ isBalanced("({[]})"));
            System.out.println("IsBalanced ([]) " + isBalanced("([])") );
            System.out.println("IsBalanced ([)] " + isBalanced("([)]"));
            System.out.println("IsBalanced ((())) " + isBalanced("((()))"));
            System.out.println("IsBalanced {[} "+ isBalanced("{[}"));
            System.out.println("isBalanced  ] " + isBalanced("]") );
            System.out.println("Is Balanced "+ isBalanced("") );

            System.out.println("Conversor de decimal a binario");
            int[] numbers = {0, 3, 4, 5, 6, 7, 9, 10, 15, 17, 23, 32, 255, 1023, 1025, 4192, 8586};

            for (int value : numbers) {
                System.out.println("Decimal: " + value + " → Binary: " + decimalToBinary(value));
            }


        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static String decimalToBinary ( int number) throws StackException {

            // Regla a: Si number es igual a cero retorne "0"
            if (number == 0) {
                return "0";
            }

            LinkedListStack linkedStack = new LinkedListStack();
            int temp = number; // Usamos una variable temporal para no modificar el parámetro original

            // Regla b: Dividir number entre 2 y agregar el residuo a la pila
            while (temp > 0) {
                linkedStack.push(temp % 2);
                temp = temp / 2;
            }

            // Regla c: Concatenar en un String todo el contenido de la pila
            String binary = "";
            while (!linkedStack.isEmpty()) {
                binary += linkedStack.pop();
            }

            return binary;
        }


}
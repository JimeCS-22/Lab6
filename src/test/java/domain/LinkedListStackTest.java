package domain;

import org.junit.jupiter.api.Test;

import static domain.LinkedListStack.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    @Test
    void Converter(){

        try {

            //Prefix to Postfix
            System.out.println("Prefix to Postfix: ");
            System.out.println("prfix: -*+fghi  to postFix:" +
                               util.Utility.prefixToPostfixConverter("-*+fghi "));

            System.out.println("prfix: *+ab-^cde to postFix:" +
                    util.Utility.prefixToPostfixConverter("*+ab-^cde"));

            System.out.println("prfix: +*+592*65 to postFix:" +
                    util.Utility.prefixToPostfixConverter("+*+592*65"));
            System.out.println();


            //Infix to postFix
            System.out.println("Infix to postFix: ");
            System.out.println("infix: ((a-b)(a+c)) to postfix: "
                               + util.Utility.infixToPostfixConverter("((a-b)*(a+c))"));

            System.out.println("infix: ((A+(B*C))+D) to postfix: " +
                    util.Utility.infixToPostfixConverter("((A+(B*C))+D)"));

            System.out.println("infix: (2*(1+((4*(2+1))+3))) to postfix: " +
                    util.Utility.infixToPostfixConverter("(2*(1+((4*(2+1))+3)))"));

            System.out.println();

            //PostFix to Infix
            System.out.println("PostFix to infix:");

            System.out.println("postfix: fgh*+i- to infix "
                    + util.Utility.postfixToInfixConverter("fgh*+i-"));

            System.out.println("postfix: 24-34*-2/ = to infix " +
                    util.Utility.postfixToInfixConverter("24-34*-2/ ="));

            System.out.println("postfix: ab-ac+*  to infix " +
                    util.Utility.postfixToInfixConverter("ab-ac+*"));




        } catch (StackException e) {

            throw new RuntimeException(e);
        }

    }

    @Test
    void test(){

        LinkedListStack linkedStack = new LinkedListStack();

        try {
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(30);
                System.out.println("Value [ "+value+" ] pushed");

                linkedStack.push(value);
            }

            System.out.println(linkedStack);
            System.out.println(linkedStack);//llamo de nuevo al toString
            System.out.println();

            System.out.println("Is Balanced Test");
            System.out.println("IsBalanced ({[]}) "+ isBalanced("({[]})"));
            System.out.println("IsBalanced ([]) " + isBalanced("([])") );
            System.out.println("IsBalanced ([)] " + isBalanced("([)]"));
            System.out.println("IsBalanced ((())) " + isBalanced("((()))"));
            System.out.println("IsBalanced {[} "+ isBalanced("{[}"));
            System.out.println("isBalanced  ] " + isBalanced("]") );
            System.out.println("Is Balanced "+ isBalanced("") );
            System.out.println();

            System.out.println("Decimal to Binary Converter.");
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
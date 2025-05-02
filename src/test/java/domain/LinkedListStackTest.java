package domain;

import domain.stack.LinkedListStack;
import domain.stack.StackException;
import org.junit.jupiter.api.Test;

import static domain.stack.LinkedListStack.isBalanced;

class LinkedListStackTest {

    @Test
    void test() {

        LinkedListStack linkedStack = new LinkedListStack();

        try {
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(30);
                System.out.println("Value [" + value + "} pushed");
                linkedStack.push(value);
            }

            System.out.println(linkedStack);
            System.out.println(linkedStack);//llamo de nuevo al toString

            System.out.println("Is Balanced Test");
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

    @Test
    void Converter() {

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
                    + util.Utility.infixToPrefixConverter("((a-b)*(a+c))"));

            System.out.println("infix: ((A+(B*C))+D) to postfix: " +
                    util.Utility.infixToPrefixConverter("((A+(B*C))+D)"));

            System.out.println("infix: (2*(1+((4*(2+1))+3))) to postfix: " +
                    util.Utility.infixToPrefixConverter("(2*(1+((4*(2+1))+3)))"));

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
    void BaseConverter() {
        try {
            // Pruebas para conversión a binario
            System.out.println("Conversor de decimal a binario");
            int[] numbers = {0, 3, 4, 5, 6, 7, 9, 10, 15, 17, 23, 32, 255, 1023, 1025, 4192, 8586};

            for (int value : numbers) {
                System.out.println("Decimal: " + value + " → Binary: " + util.Utility.convertToBase(value, 2));
            }

            // Separador entre pruebas
            System.out.println("\n----------------------------------------\n");

            // Pruebas para conversión a octal
            System.out.println("Conversor de decimal a octal");
            for (int value : numbers) {
                System.out.println("Decimal: " + value + " → Octal: " + util.Utility.convertToBase(value, 8));
            }

            // Separador entre pruebas
            System.out.println("\n----------------------------------------\n");

            // Pruebas para conversión a hexadecimal
            System.out.println("Conversor de decimal a hexadecimal");
            for (int value : numbers) {
                System.out.println("Decimal: " + value + " → Hexadecimal: " + util.Utility.convertToBase(value, 16));
            }

        } catch (Exception ex) {
            System.err.println("Error durante las pruebas: " + ex.getMessage());
        }
    }
}
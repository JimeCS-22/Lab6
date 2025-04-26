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
            System.out.println(isBalanced("({[]})"));
            System.out.println(isBalanced("([])") );
            System.out.println(isBalanced("([)]"));
            System.out.println(isBalanced("((()))"));
            System.out.println(isBalanced("{[}") );
            System.out.println(isBalanced("]") );
            System.out.println(isBalanced("") );

            System.out.println("Conversor de decimal a binario");
            System.out.println("Decimal: 0 → Binario: " + convertirDecimalABinario(0));
            System.out.println("Decimal: 3 → Binario: " + convertirDecimalABinario(3));
            System.out.println("Decimal: 4 → Binario: " + convertirDecimalABinario(4));
            System.out.println("Decimal: 5 → Binario: " + convertirDecimalABinario(5));
            System.out.println("Decimal: 6 → Binario: " + convertirDecimalABinario(6));
            System.out.println("Decimal: 7 → Binario: " + convertirDecimalABinario(7));
            System.out.println("Decimal: 9 → Binario: " + convertirDecimalABinario(9));
            System.out.println("Decimal: 10 → Binario: " + convertirDecimalABinario(10));
            System.out.println("Decimal: 15 → Binario: " + convertirDecimalABinario(15));
            System.out.println("Decimal: 17 → Binario: " + convertirDecimalABinario(17));
            System.out.println("Decimal: 23 → Binario: " + convertirDecimalABinario(23));
            System.out.println("Decimal: 32 → Binario: " + convertirDecimalABinario(32));
            System.out.println("Decimal: 255 → Binario: " + convertirDecimalABinario(255));
            System.out.println("Decimal: 1023 → Binario: " + convertirDecimalABinario(1023));
            System.out.println("Decimal: 1025 → Binario: " + convertirDecimalABinario(1025));
            System.out.println("Decimal: 4192 → Binario: " + convertirDecimalABinario(4192));
            System.out.println("Decimal: 2586 → Binario: " + convertirDecimalABinario(2586));


        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static String convertirDecimalABinario(int numeroDecimal) throws StackException {

        if (numeroDecimal == 0) {
                return "0";
            }

            LinkedListStack linkedListStack = new LinkedListStack();

            while (numeroDecimal > 0) {
                int residuo = numeroDecimal % 2;
                linkedListStack.push(residuo);
                numeroDecimal = numeroDecimal / 2;
            }

            String binario = "";
            while (!linkedListStack.isEmpty()) {
                binario += linkedListStack.pop();
            }

            return binario;
        }

}
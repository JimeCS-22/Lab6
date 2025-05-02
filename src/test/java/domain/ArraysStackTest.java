package domain;

import domain.stack.ArraysStack;
import domain.stack.Person;
import domain.stack.StackException;
import org.junit.jupiter.api.Test;

class ArraysStackTest {

    @Test
    void test() {
        ArraysStack arrayStack = new ArraysStack(11);
        try {
//            for(int i = 0; i < 10; i++){
//                int value = util.Utility.random(30);
//                System.out.println("Value ["+ value+"] pushed");
//                arrayStack.push(value);
//            }
//            System.out.println(arrayStack);
//
//            System.out.println(arrayStack);

            //Testeo con los nombres
            System.out.println("Test for arrayStack with names");
            arrayStack.push(new Person(1, "Alanna", 18));
            arrayStack.push(new Person(2, "Pablo", 20));
            arrayStack.push(new Person(3, "Ana", 21));
            arrayStack.push(new Person(4, "Maria", 20));
            arrayStack.push(new Person(5, "Victoria", 18));
            arrayStack.push(new Person(6, "Nicole", 19));
            arrayStack.push(new Person(7, "Mateo", 18));
            arrayStack.push(new Person(8, "Nicole", 23));
            arrayStack.push(new Person(9, "Alana", 22));
            arrayStack.push(new Person(10, "Pablo", 19));
            arrayStack.push(new Person(11, "Ana", 18));

            // Mostrar el contenido inicial de la pila
            System.out.println("Contenido inicial de la pila:");
            System.out.println(arrayStack);


            // --- Caso 1: Desapilar age=18, nombre inicia con A ---
            System.out.println("\nCaso 1: Desapilando personas con edad 18 y nombre que inicia con A:");
            ArraysStack tempStack1 = new ArraysStack(arrayStack.getN());
            ArraysStack removedCase1 = new ArraysStack(arrayStack.getN());
            while (!arrayStack.isEmpty()) {
                Person person = (Person) arrayStack.pop();
                if (person.getAge() == 18 && person.getName().startsWith("A")) {
                    System.out.println("Desapilado: " + person);
                    removedCase1.push(person);
                } else {
                    tempStack1.push(person);
                }
            }
            // Re-apilar los elementos no desapilados
            while (!tempStack1.isEmpty()) {
                arrayStack.push(tempStack1.pop());
            }
            System.out.println("\nContenido de la pila después del Caso 1:");
            System.out.println(arrayStack);

            // --- Caso 2: Desapilar name=Nicole, age=19 ---
            System.out.println("\nCaso 2: Desapilando personas con nombre Nicole y edad 19:");
            ArraysStack tempStack2 = new ArraysStack(arrayStack.getN());
            Person removedCase2 = null;
            while (!arrayStack.isEmpty()) {
                Person person = (Person) arrayStack.pop();
                if (removedCase2 == null && person.getName().equals("Nicole") && person.getAge() == 19) {
                    System.out.println("Desapilado: " + person);
                    removedCase2 = person;
                } else {
                    tempStack2.push(person);
                }
            }
            // Re-apilar los elementos no desapilados
            while (!tempStack2.isEmpty()) {
                arrayStack.push(tempStack2.pop());
            }
            System.out.println("\nContenido de la pila después del Caso 2:");
            System.out.println(arrayStack);

            // --- Caso 3: Desapilar age entre 20 y 23 años ---
            System.out.println("\nCaso 3: Desapilando personas con edad entre 20 y 23 años:");
            ArraysStack tempStack3 = new ArraysStack(arrayStack.getN());
            ArraysStack removedCase3 = new ArraysStack(arrayStack.getN());
            while (!arrayStack.isEmpty()) {
                Person person = (Person) arrayStack.pop();
                if (person.getAge() >= 20 && person.getAge() <= 23) {
                    System.out.println("Desapilado: " + person);
                    removedCase3.push(person);
                } else {
                    tempStack3.push(person);
                }
            }
            // Re-apilar los elementos no desapilados
            while (!tempStack3.isEmpty()) {
                arrayStack.push(tempStack3.pop());
            }
            System.out.println("\nContenido de la pila después del Caso 3:");
            System.out.println(arrayStack);


        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
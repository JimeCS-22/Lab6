package domain.queue.Domain;

import domain.stack.StackException;
import domain.stack.Person;
import org.junit.jupiter.api.Test;
import util.Utility;

class ArrayQueueTest {

    @Test
    void test() {
        ArrayQueue arrayQueue = new ArrayQueue(20);

        try {

            //Encolar a los 20 objetos y mostrarlos
            for (int i = 0; i < 20; i++) {

                arrayQueue.enQueue(new Person(util.Utility.getNames() ,util.Utility.getMoods() , util.Utility.random(100)));

            }//for

            System.out.println(arrayQueue);
            System.out.println();

            //Pruebas de metodos indexof , contains , size
            System.out.println("Testing the methods");
            System.out.println();
            System.out.println("Size: " + arrayQueue.size());
            System.out.println();
            System.out.println("Indexof: ");

            for (int i = 0; i < 5; i++) {

                Person randomPerson = new Person(Utility.getNames(), Utility.getMoods(), Utility.random(100));
                System.out.println("Looking for: " + randomPerson);

                //Comprobar si la persona esta o no
                if (arrayQueue.contains(randomPerson)){

                    System.out.println("If it contains: " + randomPerson + "is in the index: " + arrayQueue.indexOf(randomPerson));

                }else{

                    System.out.println("Does not contain: " + randomPerson);
                }//else

            }//for
            System.out.println();
            System.out.println("Uncouple people with a Cheerful mood:");

            ArrayQueue tempQueue = new ArrayQueue(arrayQueue.size());
            Person dequeuedPerson;
            int count = 0;

            while (!arrayQueue.isEmpty()) {
                dequeuedPerson = (Person) arrayQueue.deQueue();
                if (dequeuedPerson.getMood().equalsIgnoreCase("Cheerful")) {
                    System.out.println("  - Dequeuing: " + dequeuedPerson);
                    count++;
                } else {
                    tempQueue.enQueue(dequeuedPerson);
                }
            }//while
            arrayQueue = tempQueue; // Reemplazar la cola original con la temporal

            System.out.println();
            System.out.println("Number of people 'Cheerful' unqueued: " + count);
            System.out.println();

            // Mostrar el contenido final de la cola
            System.out.println("Final queue content:");
            System.out.println(arrayQueue);

        } catch (QueueException e) {
            throw new RuntimeException(e);
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

}
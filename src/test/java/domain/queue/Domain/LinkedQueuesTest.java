package domain.queue.Domain;

import org.junit.jupiter.api.Test;

import static Domain.LinkedQueue.isBalanced;

class LinkedQueuesTest {

    @Test
    void test1() {
        try {
            LinkedQueue linkedQueue = new LinkedQueue();
            String[] array = {"(())()", "(()", "())(", "", "((()))", "(()(()))"};
            for (String i : array) {
                boolean result = isBalanced(linkedQueue, i);
                System.out.println("Expression: " + i + " → "
                        + (result ? "is balanced " : "is not balanced "));
            }

            System.out.println();

            for (int i = 0; i < 20; i++)
                linkedQueue.enQueue(util.Utility.random(20));
            System.out.println("___With duplicates" + linkedQueue);
            removeDuplicates(linkedQueue);
            System.out.println("___Without duplicates" + linkedQueue);

        } catch (QueueException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void test2() {
        LinkedQueue linkedQueue = new LinkedQueue();
        try {
            for (int i = 0; i < 15; i++)
                linkedQueue.enQueue(util.Utility.random(30));
            System.out.println(linkedQueue);
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }
    }


    private void removeDuplicates(LinkedQueue linkedQueue) throws QueueException {

        LinkedQueue aux = new LinkedQueue();

        while (!linkedQueue.isEmpty()) {
            Object count = linkedQueue.deQueue();
            boolean isDuplicate = false;
            
            LinkedQueue tempQueue = new LinkedQueue();
            while (!aux.isEmpty()) {
                Object uniqueElement = aux.deQueue();
                if (count != null && count.equals(uniqueElement)) {
                    isDuplicate = true;
                } else if (count == null && uniqueElement == null) {
                    isDuplicate = true;
                }
                tempQueue.enQueue(uniqueElement);
            }

            while (!tempQueue.isEmpty()) {
                aux.enQueue(tempQueue.deQueue());
            }

            if (!isDuplicate) {
                aux.enQueue(count);
            }
        }

        while (!aux.isEmpty()) {
            linkedQueue.enQueue(aux.deQueue());
        }



    }
}
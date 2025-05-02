package domain.queue.Domain;

import org.junit.jupiter.api.Test;

class HeaderLinkedQueuesTest {

    @Test
    void test1(){
        try {
            HeaderLinkedQueue q1 = new HeaderLinkedQueue();
            HeaderLinkedQueue q2 = new HeaderLinkedQueue();
            HeaderLinkedQueue q3 = new HeaderLinkedQueue();

            for (int i = 0; i <20 ; i++)
                q1.enQueue(new Climate(new Place(util.Utility.getPlace()),
                        new Weather(util.Utility.getWeather())));
            System.out.println(q1);
            System.out.println();

            // b. Desencolar objetos "sunny" y "foggy" de q1 y encolarlos en q2
            System.out.println("Q2 with elements sunny and foggy:");

            HeaderLinkedQueue tempQ1_b = new HeaderLinkedQueue(); // Cola temporal para no perder el orden original de q1
            Climate climate_b;
            while (!q1.isEmpty()) {
                climate_b = (Climate) q1.deQueue();
                String weatherDescription = climate_b.getWeather().getDescription();
                if (weatherDescription.equalsIgnoreCase("sunny") || weatherDescription.equalsIgnoreCase("foggy")) {
                    q2.enQueue(climate_b);
                } else {
                    tempQ1_b.enQueue(climate_b);
                }
            }
            q1 = tempQ1_b;// Restaurar q1 con los elementos restantes

            // c. Mostrar el contenido de q1 y q2
            System.out.println(" Content Q2 " + q2);
            System.out.println("Content q1 " + q1);
            System.out.println();

            // d. Desencolar objetos de "Paraíso" y "Liberia" de q1 y encolarlos en q3
            System.out.println("Q3 with elements Paraiso and Liberia");
            HeaderLinkedQueue tempQ1_d = new HeaderLinkedQueue();
            Climate climate_d;
            while (!q1.isEmpty()) {
                climate_d = (Climate) q1.deQueue();
                String placeName = climate_d.getPlace().getName();
                if (placeName.equalsIgnoreCase("Paraíso") || placeName.equalsIgnoreCase("Liberia")) {
                    q3.enQueue(climate_d);
                } else {
                    tempQ1_d.enQueue(climate_d);
                }
            }
            q1 = tempQ1_d;

            // e. Mostrar el contenido de q1 y q3
            System.out.println("Content Q3 " + q3);
            System.out.println("Content Q1 " +  q1);
            System.out.println();

            // f. Desencolar objetos "thunderstorm" y "cloudy" de q1 y encolarlos en q2 y q3
            System.out.println("Elements thunderstorm and cloudy in Q2 and Q3");
            HeaderLinkedQueue tempQ1_f = new HeaderLinkedQueue();
            Climate climate_f;
            while (!q1.isEmpty()) {
                climate_f = (Climate) q1.deQueue();
                String weatherDescription = climate_f.getWeather().getDescription();
                if (weatherDescription.equalsIgnoreCase("thunderstorm") || weatherDescription.equalsIgnoreCase("cloudy")) {
                    q2.enQueue(climate_f);
                    q3.enQueue(climate_f);
                } else {
                    tempQ1_f.enQueue(climate_f);
                }
            }
            q1 = tempQ1_f;

            // g. Mostrar el contenido de q1, q2 y q3
            System.out.println("Final content q1:");
            System.out.println(q1);
            System.out.println("Final content q2:");
            System.out.println(q2);
            System.out.println("Final content q3:");
            System.out.println(q3);

            System.out.println(q2);

        } catch (QueueException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test2() {
        HeaderLinkedQueue headerLinkedQueue = new HeaderLinkedQueue();
        try {
            for (int i = 0; i < 15; i++)
                headerLinkedQueue.enQueue(util.Utility.random(30));
            System.out.println(headerLinkedQueue);
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }
    }
}
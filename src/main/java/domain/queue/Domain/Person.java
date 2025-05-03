package domain.queue.Domain;

import java.util.Objects;

public class Person {
    private String name;
    private String mood;
    private int attentionTime; // en minutos
    private String priority;

    public Person(String name, String mood, int attentionTime, String priority) {
        this.name = name;
        this.mood = mood;
        this.attentionTime = attentionTime;
        this.priority = priority;
    }

    // Getters
    public String getName() { return name; }
    public String getMood() { return mood; }
    public int getAttentionTime() { return attentionTime; }
    public String getPriority() { return priority; }

    // Método especial para mostrar el tiempo formateado
    public String getAttentionTimeFormatted() {
        return attentionTime + " minutos";
    }

    // Setters
    public void setPriority(String priority) { this.priority = priority; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(mood, person.mood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mood);
    }
}

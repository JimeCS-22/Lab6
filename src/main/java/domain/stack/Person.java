package domain.stack;

import java.util.Objects;

public class Person {

    private String name;
    private String mood;
    private int attentionTime;//expresado en milesegundos

    public Person(String name, String mood, int attentionTime) {
        this.name = name;
        this.mood = mood;
        this.attentionTime = attentionTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(int attentionTime) {
        this.attentionTime = attentionTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                " " + name + '\'' +
                ", " + mood + '\'' +
                ", " + attentionTime +
                '}';
    }
}

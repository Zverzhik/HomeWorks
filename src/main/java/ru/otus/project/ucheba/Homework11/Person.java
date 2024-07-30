package ru.otus.project.ucheba.Homework11;

import java.util.Objects;

public class Person {
    private final String name;
    private final Position position;
    private final Long id;

    public Person(String name, Position position, Long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public Position getPosition() {
        return position;
    }
    public Long getId() {
        return id;
    }



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(name, person.name) && position == person.position && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", id=" + id +
                '}';
    }
}

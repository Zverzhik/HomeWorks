package ru.otus.project.ucheba.Homework11;

import java.util.HashMap;
import java.util.Map;
import ru.otus.project.ucheba.Homework11.Position;

public class PersonDataBase {
    private final Map<Long, Person> list;

    public PersonDataBase() {
        this.list = new HashMap<>();
    }

    public Person findByld(Long id) {
        return list.getOrDefault(id,null);
    }
    public void add(Person person) {
        list.put(person.getId(), person);
    }
    public boolean isManager(Person person) {
        return person.getPosition().isManager();
    }
    public boolean isEmployee(Long id) {
        if (id != null) {
            return findByld(id).getPosition().isEmployee();
        } else {
            System.out.println("ID не найден!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "PersonDataBase{" +
                "list=" + list +
                '}';
    }
}

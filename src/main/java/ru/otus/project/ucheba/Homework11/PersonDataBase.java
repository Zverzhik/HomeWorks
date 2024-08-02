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
        Person person = findByld(id);
        if (id != null && findByld(id) != null) {
            return findByld(id).getPosition().isEmployee();
        } else {
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

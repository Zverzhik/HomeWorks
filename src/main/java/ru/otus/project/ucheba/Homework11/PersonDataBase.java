package ru.otus.project.ucheba.Homework11;

import java.util.Map;
import ru.otus.project.ucheba.Homework11.Position;

public class PersonDataBase {
    private final Map<Long, Person> list;

    public PersonDataBase(Map<Long, Person> list) {
        this.list = list;
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
        return findByld(id).getPosition().isEmployee();
    }

    @Override
    public String toString() {
        return "PersonDataBase{" +
                "list=" + list +
                '}';
    }
}

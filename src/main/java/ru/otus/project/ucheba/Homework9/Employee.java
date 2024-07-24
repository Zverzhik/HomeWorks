package ru.otus.project.ucheba.Homework9;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public static List<String> Names (List<Employee> staff) {
        List<String> staffNames = new ArrayList<>();
        for (Employee employee : staff) {
            if (employee != null) {
                staffNames.add(employee.getName());
            }
        }
        return staffNames;
    }

    public static List<String> MinAgeStaff (List<Employee> staff, int minAge) {
        List<String> minAgeStaff = new ArrayList<>();
        for (Employee employee : staff) {
            if (employee != null) {
                if (employee.getAge() >= minAge) {
                    minAgeStaff.add(employee.getName());
                }
            }
        }
        return minAgeStaff;
    }

    public static boolean checkMiddleAverageAgeStaff (List<Employee> staff, int minAverageAge) {
        int averageAge = 0;
        for (Employee employee : staff) {
            if (employee != null) {
                averageAge += employee.getAge();
            }
        }
        averageAge = averageAge / staff.size();
        return averageAge > minAverageAge;
    }

    public static Employee youngestEmployee (List<Employee> staff) {
        Employee youngEmployee = staff.get(0);
        for (Employee employee : staff) {
            if (employee != null) {
                if (youngEmployee.getAge() > employee.getAge()) {
                    youngEmployee = employee;
                }
            }
        }
        return youngEmployee;
    }

    @Override
    public String toString() {
        return "Сотрудник: " + name + " " + age + "лет";
    }
}

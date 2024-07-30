package ru.otus.project.ucheba.Homework9;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain extends Employee {
    public EmployeeMain(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivan", 30);
        Employee employee2 = new Employee("Maria", 47);
        Employee employee3 = new Employee("Ilya", 25);
        Employee employee4 = new Employee("Kate", 38);
        Employee employee5 = new Employee("Robin", 61);

        List<Employee> staff = new ArrayList<>();
        staff.add(employee1);
        staff.add(employee2);
        staff.add(employee3);
        staff.add(employee4);
        staff.add(employee5);

        List<String> staffNames = names(staff);
        System.out.println(staffNames);

        List<String> minAgeStaff = minAgeStaff(staff, 30);
        System.out.println(minAgeStaff);

        boolean averageAgeStaff = checkMiddleAverageAgeStaff(staff,42);
        System.out.println(averageAgeStaff);

        Employee youngestEmployee = youngestEmployee(staff);
        System.out.println(youngestEmployee);
    }
}

package ru.otus.project.ucheba.Homework7;

import ru.otus.project.ucheba.Homework7.transport.Transport;

public class Human {
    private final String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
        this.currentTransport = null;
    }

    public void take(Transport transport) {
        if (currentTransport != null) {
            System.out.println("Транспорт занят");
            return;
        }
        currentTransport = transport;
        System.out.println(name + " сел в транспорт " + transport);
    }
    public void release(Transport transport) {
        currentTransport = null;
        System.out.println(name + " покинул " + transport);
    }

    public boolean move(TerrainType area, int distance) {
        if (currentTransport == null) {
            System.out.println(name + " прошел пешком " + distance + " км по местности - " + area.getName());
            return true;
        }
        return currentTransport.move(area, distance);
    }

    public String getName() {
        return name;
    }
}

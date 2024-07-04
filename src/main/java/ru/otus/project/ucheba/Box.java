package ru.otus.project.ucheba;

public class Box {
    private String color;
    private int length;
    private int width;
    private int height;
    private boolean isOpened;
    private String item;

    public void setColor(String color) {
        this.color = color;
    }
    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public Box(String color, int length, int width, int height) {
        this.color = "Серая";
        this.length = 10;
        this.width = 10;
        this.height = 7;
    }

    public void open() {
        isOpened = true;
            System.out.println("Коробка открыта");
        }
    public void close() {
        isOpened = false;
        System.out.println("Коробка закрыта");
    }
    public void info() {
        System.out.println("Коробка " + color + " с размерами " + length + "x" + width + "x" + height);
    }
    public void putIn(String item) {
        if (this.item != null) {
            System.out.println("В коробке лежит предмет");
        } else {
            this.item = item;
            System.out.println("Положить в коробку " + item);
        }
    }
    public void getFrom(String item) {
        if (item == null) {
            System.out.println("В коробке нет предмета");
        } else {
            item = null;
            System.out.println("Взять из коробки " + item);
        }
    }
}

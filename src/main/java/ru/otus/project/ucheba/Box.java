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
        System.out.println("Коробка открыта");
    }
    public void close() {
        System.out.println("Коробка закрыта");
    }
    public void info() {
        System.out.println("Коробка " + color + " с размерами " + length + "x" + width + "x" + height);
    }
    public void putIn(String item) {
        this.item = item;
        if (isOpened) {
            String[] items = new String[5];
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    System.out.println("Положить в коробку " + item);
                }
            }
        } else {
            System.out.println("Сначала откройте коробку!");
        }
    }
    public void getFrom(String item) {
        this.item = item;
        if (isOpened) {
            String[] items = new String[5];
            for (int i = 0; i < items.length; i++) {
                if (item.equals(items[i])) {
                    items[i] = null;
                    System.out.println("Взять из коробки " + item);
                }
            }
        } else {
            System.out.println("Сначала откройте коробку!");
        }
    }
}

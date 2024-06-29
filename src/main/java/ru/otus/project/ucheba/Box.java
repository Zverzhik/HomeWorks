package ru.otus.project.ucheba;

public class Box {
    private String color;
    private int length;
    private int width;
    private int height;
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

    public void openBox() {
        System.out.println("Коробка открыта");
    };
    public void closeBox() {
        System.out.println("Коробка закрыта");
    }
    public void info() {
        System.out.println("Коробка " + color + " с размерами " + length + "x" + width + "x" + height);
    }
    public void putInBox(String item) {
        this.item = item;
        openBox();
        Box[] contant = new Box[5];
        for (int i = 0; i < contant.length ; i++) {
            if (contant[i] == null) {
                System.out.println("Положить в коробку " + item);
            }
        }
    }
    public void getFromBox(String item) {
        this.item = item;
        openBox();
        Box[] contant = new Box[5];
        for (int i = 0; i < contant.length ; i++) {
            if (item.equals(contant[i])) {
                contant[i] = null;
                System.out.println("Взять из коробки " + item);
            }
        }
    }
}
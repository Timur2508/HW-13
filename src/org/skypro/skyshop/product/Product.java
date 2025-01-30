package org.skypro.skyshop.product;

public class Product {
    private final String name; // Название продукта
    private final int price;    // Стоимость продукта

    // Конструктор класса
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Метод для получения названия продукта
    public String getName() {
        return name;
    }

    // Метод для получения стоимости продукта
    public int getPrice() {
        return price;
    }
}

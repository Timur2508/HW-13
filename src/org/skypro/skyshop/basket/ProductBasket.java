package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products; // Массив для хранения продуктов
    private int productCount;   // Счетчик добавленных продуктов

    // Конструктор класса
    public ProductBasket() {
        products = new Product[5]; // Инициализация массива на 5 элементов
        productCount = 0;          // Начальное значение счетчика
    }

    // Метод добавления продукта в корзину
    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product; // Добавление продукта в корзину
            productCount++;                   // Увеличение счетчика
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    // Метод получения общей стоимости корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < productCount; i++) {
            totalCost += products[i].getPrice(); // Суммирование цен продуктов
        }
        return totalCost;
    }

    // Метод печати содержимого корзины
    public void printBasket() {
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    // Метод проверки наличия продукта в корзине по имени
    public boolean containsProduct(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(productName)) {
                return true; // Продукт найден
            }
        }
        return false; // Продукт не найден
    }

    // Метод очистки корзины
    public void clearBasket() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null; // Очистка массива
        }
        productCount = 0; // Сброс счетчика
    }
}

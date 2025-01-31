package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 30);
        Product milk = new Product("Молоко", 40);
        Product meat = new Product("Мясо", 150);
        Product fish = new Product("Рыба", 200);
        Product cheese = new Product("Сыр", 120);

        System.out.println("Добавление продуктов в корзину:");
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(meat);
        basket.addProduct(fish);

        System.out.println("Попытка добавить продукт в заполненную корзину:");
        basket.addProduct(cheese);

        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        int totalCost = basket.getTotalCost();
        System.out.println("\nОбщая стоимость корзины: " + totalCost);

        boolean containsApple = basket.containsProduct("Яблоко");
        System.out.println("Корзина содержит яблоко: " + containsApple);

        boolean containsBanana = basket.containsProduct("Банан");
        System.out.println("Корзина содержит банан: " + containsBanana);

        basket.clearBasket();
        System.out.println("\nКорзина очищена.");

        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        totalCost = basket.getTotalCost();
        System.out.println("Общая стоимость пустой корзины: " + totalCost);

        containsApple = basket.containsProduct("Яблоко");
        System.out.println("Корзина содержит яблоко: " + containsApple);
    }
}
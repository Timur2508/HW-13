package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        // Создание экземпляра корзины
        ProductBasket basket = new ProductBasket();

        // Создание нескольких продуктов
        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 30);
        Product milk = new Product("Молоко", 40);
        Product meat = new Product("Мясо", 150);
        Product fish = new Product("Рыба", 200);
        Product cheese = new Product("Сыр", 120); // Продукт для проверки переполнения корзины

        // 1. Добавление продукта в корзину
        System.out.println("Добавление продуктов в корзину:");
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(meat);
        basket.addProduct(fish);

        // 2. Попытка добавить продукт в заполненную корзину
        System.out.println("Попытка добавить продукт в заполненную корзину:");
        basket.addProduct(cheese); // Должно вывести сообщение "Невозможно добавить продукт"

        // 3. Печать содержимого корзины с несколькими товарами
        System.out.println("\nСодержимое корзины:");
        basket.printBasket(); // Должно показать все добавленные продукты и итоговую стоимость

        // 4. Получение стоимости корзины с несколькими товарами
        int totalCost = basket.getTotalCost();
        System.out.println("\nОбщая стоимость корзины: " + totalCost);

        // 5. Поиск товара, который есть в корзине
        boolean containsApple = basket.containsProduct("Яблоко");
        System.out.println("Корзина содержит яблоко: " + containsApple);

        // 6. Поиск товара, которого нет в корзине
        boolean containsBanana = basket.containsProduct("Банан");
        System.out.println("Корзина содержит банан: " + containsBanana);

        // 7. Очистка корзины
        basket.clearBasket();
        System.out.println("\nКорзина очищена.");

        // 8. Печать содержимого пустой корзины
        System.out.println("\nСодержимое корзины:");
        basket.printBasket(); // Должно вывести "В корзине пусто"

        // 9. Получение стоимости пустой корзины
        totalCost = basket.getTotalCost();
        System.out.println("Общая стоимость пустой корзины: " + totalCost);

        // 10. Поиск товара по имени в пустой корзине
        containsApple = basket.containsProduct("Яблоко");
        System.out.println("Корзина содержит яблоко: " + containsApple);
    }
}
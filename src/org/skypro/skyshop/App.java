package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.BestResultNotFound;

public class App {
    public static void main(String[] args) throws RuntimeException, BestResultNotFound, IllegalAccessException {

        DiscountProduct fish = new DiscountProduct("Рыба", 346, 32);
        SimpleProduct meat = new SimpleProduct("Мясо", 86);
        SimpleProduct cheese = new SimpleProduct("Сыр", 54);
        DiscountProduct candies = new DiscountProduct("Конфеты", 452, 38);
        FixPriceProduct onion = new FixPriceProduct("Лук");
        SimpleProduct oliveOil = new SimpleProduct("Оливки", 265);
        SimpleProduct salad = new SimpleProduct("Салат", 92);

        ProductBasket basket = new ProductBasket(5);
        basket.addProduct(fish);
        basket.addProduct(cheese);
        basket.addProduct(candies);
        basket.addProduct(salad);
        basket.addProduct(onion);
        basket.addProduct(meat);
        basket.addProduct(oliveOil);

        ProductBasket.printBasket();

        basket.checkBasket("Оливки");
        basket.checkBasket("Конфеты");

        basket.clearBasket();

        basket.printBasket();
        basket.checkBasket("Салат");

        System.out.println("\n" + "ООП. Интерфейсы" + "\n");

        Article article01 = new Article("Рыба", "Рыба бывает разная, черная,белая, красная. ");
        Article article02 = new Article("Мясо", "Мясо с высоким содержанием белка и железа. ");
        Article article03 = new Article("Сыр", "Сыр любой разновидности и брэнда. ");
        Article article04 = new Article("Оливки", "Оливки без косточек. ");

        SearchEngine engines = new SearchEngine(10);
        engines.add(fish);
        engines.add(meat);
        engines.add(cheese);
        engines.add(candies);
        engines.add(article01);
        engines.add(article02);
        engines.add(article03);
        engines.add(article04);
        engines.add(onion);
        engines.add(oliveOil);
        engines.add(salad);

        try {
            SimpleProduct invalidSimpleProduct = new SimpleProduct("Рыба", 11);
            System.out.println("Создан SimpleProduct: " + invalidSimpleProduct.getTitle());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка создания SimpleProduct: " + e.getMessage());
        }

        try {
            DiscountProduct invalidDiscountedProduct1 = new DiscountProduct("Мясо", 15, 10);
            System.out.println("Создан DiscountedProduct: " + invalidDiscountedProduct1.getTitle());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка создания DiscountedProduct: " + e.getMessage());
        }

        try {
            DiscountProduct invalidDiscountedProduct2 = new DiscountProduct("Сыр", 100, 20);
            System.out.println("Создан DiscountedProduct: " + invalidDiscountedProduct2.getTitle());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка создания DiscountedProduct: " + e.getMessage());
        }

        try {
            SimpleProduct invalidProduct3 = new SimpleProduct("Оливки", 100);
            System.out.println("Создан SimpleProduct: " + invalidProduct3.getTitle());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка создания SimpleProduct: " + e.getMessage());
        }

        try {
            SimpleProduct validSimpleProduct = new SimpleProduct("Мясо", 86);
            System.out.println("Создан SimpleProduct: " + validSimpleProduct.getTitle() + ", цена: " + validSimpleProduct.getPrice());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка создания SimpleProduct: " + e.getMessage());
        }

        try {
            DiscountProduct validDiscountedProduct = new DiscountProduct("Салат", 92, 20);
            System.out.println("Создан DiscountedProduct: " + validDiscountedProduct.getTitle() + ", цена со скидкой: " + validDiscountedProduct.getPrice());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка создания DiscountedProduct: " + e.getMessage());
        }

        String searchTerm = "world";
        SearchEngine searchEngine = new SearchEngine(10);
        Searchable bestMatch = searchEngine.findBestMatch(searchTerm);
        if (bestMatch != null) {
            System.out.println("Наиболее подходящий объект: " + bestMatch.getSearchTerm());
        } else {
            System.out.println("Не найдено подходящих объектов.");
        }
    }
}


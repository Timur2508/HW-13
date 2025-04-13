package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;

public class App {
    public static void main(String[] args) throws IllegalAccessException {

        DiscountProduct fish = new DiscountProduct("Рыба", 346, 32);
        SimpleProduct meat = new SimpleProduct("Мясо", 86);
        SimpleProduct cheese = new SimpleProduct("Сыр", 54);
        DiscountProduct candies = new DiscountProduct("Конфеты", 452, 38);
        FixPriceProduct onion = new FixPriceProduct("Лук");
        SimpleProduct oliveOil = new SimpleProduct("Оливки", 265);
        SimpleProduct salad = new SimpleProduct("Салат", 92);
        System.out.println("____________________________________");
        System.out.println("Печать удаленных продуктов - продукты есть");


        ProductBasket productBasket = new ProductBasket();
        System.out.println(productBasket.removeAllProductsNamedBy("Сыр"));
        System.out.println("____________________________________");
        System.out.println("Печать удаленных продуктов - продуктов нет");
        System.out.println(productBasket.removeAllProductsNamedBy("сырная вонючка"));
        System.out.println("Interfaces");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(fish);
        basket.addProduct(cheese);
        basket.addProduct(candies);
        basket.addProduct(salad);
        basket.addProduct(onion);
        basket.addProduct(meat);
        basket.addProduct(oliveOil);

        basket.printBasket();

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

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.addSearchable(fish);
        searchEngine.addSearchable(meat);
        searchEngine.addSearchable(cheese);
        searchEngine.addSearchable(candies);
        searchEngine.addSearchable(article01);
        searchEngine.addSearchable(article02);
        searchEngine.addSearchable(article03);
        searchEngine.addSearchable(article04);
        searchEngine.addSearchable(onion);
        searchEngine.addSearchable(oliveOil);
        searchEngine.addSearchable(salad);

        String searchTerm = "Салат";
        List<Searchable> bestMatches = searchEngine.findBestMatches(searchTerm);

        if (bestMatches.isEmpty()) {
            System.out.println("Не найдено подходящих объектов.");
        } else {
            System.out.println("Найдены подходящие объекты:");
            for (Searchable match : bestMatches) {
                System.out.println("- " + match.getSearchTerm());
            }

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

            if (bestMatches.isEmpty()) {
                System.out.println("Не найдено подходящих объектов.");
            } else {
                System.out.println("Найдены подходящие объекты:");
                for (Searchable match : bestMatches) {
                    System.out.println("- " + match.getSearchTerm());
                }
            }
        }
    }
}

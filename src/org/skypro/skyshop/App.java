package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

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
        Article article03 = new Article("Сып", "Сыр любой разновидности и брэнда. ");
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

        for (Searchable engine : engines.search("Рыба")) {
            if (engine != null) {
                System.out.println(engine);
            }
        }
        for (Searchable engine : engines.search("Сыр")) {
            if (engine != null) {
                System.out.println(engine);
            }
        }
    }
}
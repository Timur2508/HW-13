package org.skypro.skyshop.product;

public class DiscountProduct extends Product {

    protected double basePrice;
    protected int discountInPercent;

    public DiscountProduct(String title, double basePrice, int discountInPercent) throws RuntimeException, IllegalAccessException {
        super(title);

        if (basePrice <= 0) {
            throw new IllegalAccessException("Базовая цена продукта должна быть строго больше 0.");
        }
        if (discountInPercent < 0 || discountInPercent > 100) {
            throw new IllegalAccessException("Процент скидки должен быть в диапазоне от 0 до 100 включительно.");
        }
        this.basePrice = basePrice;
        this.discountInPercent = discountInPercent;
    }

    @Override
    public double getPrice() {
        return (basePrice * (1 - (discountInPercent / 100)));
    }

    @Override
    public String toString() {
        return "Наименование продукта со скидкой: " + title + ", Стоимость: " + getPrice() + " (скидка: " + discountInPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
    }

    @Override
    public int countOccurrences(String searchTerm, String search) {
        return 0;
    }

    @Override
    public boolean search(String query) {
        return false;
    }
}
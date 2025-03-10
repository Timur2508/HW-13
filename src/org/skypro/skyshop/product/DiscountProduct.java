package org.skypro.skyshop.product;

public class DiscountProduct extends Product {

    protected double basePrice;
    protected int discountInPercent;

    public DiscountProduct(String title, double basePrice, int discountInPercent) {
        super(title);
        this.basePrice = basePrice;
        this.discountInPercent = discountInPercent;
    }

    @Override
    public double getPrice() {
        return (basePrice - (basePrice * discountInPercent / 100));
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
}
package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    protected double price;

    public double getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    public SimpleProduct(String title, double price) throws IllegalAccessException {
        super(title);
        if (price <= 0) {
            throw new IllegalAccessException("цена продукта должна быть строго больще 0.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Наименование продукта: " + getTitle() + ", Стоимость: " + getPrice();
    }
}
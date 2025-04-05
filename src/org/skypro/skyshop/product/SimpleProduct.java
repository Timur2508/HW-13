package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    protected double price;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public SimpleProduct(String title, double price) throws RuntimeException, IllegalAccessException {
        super(title);
        if (price <= 0) {
            throw new IllegalAccessException("цена продукта должна быть строго больще 0.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Наименование продукта: " + title + ", Стоимость: " + getPrice() ;
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
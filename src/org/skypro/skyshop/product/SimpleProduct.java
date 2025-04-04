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

    public SimpleProduct(String title, double price) {
        super(title);
        this.price = price;
    }

    @Override
    public String toString() {
        return "Наименование продукта: " + title + ", Стоимость: " + getPrice() ;
    }
}
package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {

    protected String title;

    public Product(String title) {
        this.title = title;
    }

    public Product() {
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    public abstract String getTitle();

    public abstract void setTitle(String title);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public abstract void setPrice(double price);
}


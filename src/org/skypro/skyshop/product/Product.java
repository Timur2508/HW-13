package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    protected String title;

    public Product(String title) {
        this.title = title;
    }

    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public abstract void setPrice(double price);

    @Override
    public abstract String toString();
}
package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private String title;

    public Product(String title) throws IllegalAccessException {
        this.title = title;
        if (title == null || title.isBlank()) {
            throw new IllegalAccessException("название продукта не может быть пустым или состоять только из пробелов");
        }
    }

    public abstract double getPrice();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
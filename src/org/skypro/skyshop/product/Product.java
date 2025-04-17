package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    protected String title;

    public Product(String title) throws IllegalAccessException {
        if (title == null || title.isBlank()) {
            throw new IllegalAccessException("название продукта не может быть пустым или состоять только из пробелов");
        }

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
    public int countOccurrences(String searchTerm, String search) {
        String str = this.getStringRepresentation(this).toLowerCase();
        String substr = search.toLowerCase();
        int count = 0;
        int index = 0;
        int indexSubstr = str.indexOf(substr, index);
        while (indexSubstr != -1) {
            count++;
            index = indexSubstr + substr.length();
            indexSubstr = str.indexOf(substr, index);
        }
        return count;
    }

    @Override
    public boolean search(String query) {
        return countOccurrences(getSearchTerm(), query) > 0;
    }
}
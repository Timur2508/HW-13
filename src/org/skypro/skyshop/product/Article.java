package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}


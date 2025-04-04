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
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public int countOccurrences(String searchTerm, String search) {
        return 0;
    }

    @Override
    public boolean search(String query) {
        return false;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}
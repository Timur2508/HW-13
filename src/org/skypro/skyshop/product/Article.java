package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private String title;
    private String contentType;

    public Article(String title, String contentType) {
        this.title = title;
        this.contentType = contentType;
    }

    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
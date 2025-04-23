package org.skypro.skyshop;

import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Product;

public interface Searchable {

    String getSearchTerm();
    String getContentType();
    String getTitle();

    default String getStringRepresentation(Searchable searchable) {
        return searchable.getSearchTerm() + " (" + searchable.getContentType() + ")";
    }
}
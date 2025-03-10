package org.skypro.skyshop;

public interface Searchable {

    String getSearchTerm();

    String getContentType();


    default void getStringRepresentation(Searchable searchable) {
        System.out.println(getSearchTerm() + getContentType());
    }
}
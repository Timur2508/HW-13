package org.skypro.skyshop;

public interface Searchable {


    String searchTerm();

    String contentType();


    default void getStringRepresentation() {
        System.out.println(searchTerm() + " " + contentType());
    }
}
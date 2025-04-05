package org.skypro.skyshop;

public interface Searchable {

    String getSearchTerm();

    String getContentType();


    default String getStringRepresentation(Searchable searchable){
        return searchable.getSearchTerm() + searchable.getContentType();
    }

    default int getSearchTerm(String str, String substr){
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

    int countOccurrences(String searchTerm, String search);

    boolean search(String query);
}
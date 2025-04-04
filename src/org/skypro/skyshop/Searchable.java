package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

public interface Searchable {

    String getSearchTerm();

    String getContentType();


    default void getStringRepresentation(Searchable searchable) {
        System.out.println(getSearchTerm() + getContentType());
    }

    List<Searchable> searchables = new ArrayList<>();

    public default void addSearchable(Searchable searchable) {
        if (searchables.add(searchable)) ;

    }

    public default Searchable findBestMatch(String search) throws BestResultNotFoundException {
        if (searchables.isEmpty()) {
            throw new BestResultNotFoundException(search);
        }

        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchables) {
            String searchTerm = searchable.getSearchTerm();
            int occurrences = countOccurrences(searchTerm, search);

            if (occurrences > occurrences) {
                maxOccurrences = occurrences;
                bestMatch = searchable;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFoundException(search);
        }

        return bestMatch;
    }

    int countOccurrences(String searchTerm, String search);

    boolean search(String query);
}
package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountProduct;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public SearchEngine (int initialCapacity) {
        this.searchables = new ArrayList<>(initialCapacity);
    }

    public void addSearchable(Searchable searchable) {
        this.searchables.add(searchable);
    }

    public List<Searchable> findBestMatches(String search) {
        List<Searchable> bestMatches = new ArrayList<>();
        int maxOccurrences = 0;

        for (Searchable searchable : searchables) {
            String searchTerm = searchable.getSearchTerm();
            int occurrences = countOccurrences(searchTerm, search);

            if (occurrences > 0) {
                if (occurrences > maxOccurrences) {
                    bestMatches.clear();
                    bestMatches.add(searchable);
                    maxOccurrences = occurrences;
                } else if (occurrences == maxOccurrences) {
                    bestMatches.add(searchable);
                }
            }
        }

        return bestMatches;
    }

    private int countOccurrences(String text, String subString) {
        if (text == null || subString == null || subString.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        while ((index = text.toLowerCase().indexOf(subString.toLowerCase(), index)) != -1) {
            count++;
            index += subString.length();
        }
        return count;

    }

    public Searchable findBestMatch(String searchTerm) {
        return null;
    }
}
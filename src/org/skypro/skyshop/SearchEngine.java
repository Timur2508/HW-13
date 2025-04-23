package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.SearchableComparator;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables = new HashSet<>();

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public SearchEngine(int initialCapacity) {
        this.searchables = new HashSet<>(initialCapacity);
    }

    public void addSearchable(Searchable searchable) {
        this.searchables.add(searchable);
    }

    public SortedSet<Searchable> findBestMatches(String search) {
        SortedSet<Searchable> bestMatches = new TreeSet<>(new SearchableComparator());

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(search)) {
                bestMatches.add(searchable);
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
}
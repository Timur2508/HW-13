package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.SearchableComparator;

import java.util.*;
import java.util.stream.Collectors;

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

        return searchables.stream()
                .filter(searchable -> searchable.getSearchTerm().contains(search))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
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
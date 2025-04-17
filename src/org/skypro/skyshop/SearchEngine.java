package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public SearchEngine(int initialCapacity) {
        this.searchables = new ArrayList<>(initialCapacity);
    }

    public void addSearchable(Searchable searchable) {
        this.searchables.add(searchable);
    }

    // Модифицированный метод поиска, возвращающий отсортированную по имени Map
    public SortedMap<String, Searchable> findBestMatches(String search) {
        SortedMap<String, Searchable> bestMatches = new TreeMap<>();

        for (Searchable searchable : searchables) {
            if (searchable.search(search)) { // Используем метод search() из интерфейса
                bestMatches.put(searchable.getSearchTerm(), searchable);
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
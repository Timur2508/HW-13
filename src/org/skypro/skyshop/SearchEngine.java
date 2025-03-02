package org.skypro.skyshop;

public class SearchEngine {
    private Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchables.length) {
            searchables[count++] = item;
        } else {
            System.out.println("Невозможно добавить " + item + ", т.к. массив заполнен!");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (Searchable item : searchables) {
            if (item != null && item.searchTerm().contains(query)) {
                searchables[foundCount++] = item;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}
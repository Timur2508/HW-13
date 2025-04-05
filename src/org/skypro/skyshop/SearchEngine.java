package org.skypro.skyshop;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count;

    public SearchEngine(int size){
        this.searchables = new Searchable[size];
        count = 0;
    }

    public String search (String text){
        Searchable[] result = new Searchable[5];
        int i = 0;
        for (Searchable s: searchables){
            if (s == null){
                break;
            }
            if (i == result.length){
                return "Мест нет";
            }
            String term = s.getSearchTerm();
            if (term.contains(text)) {
                result[i] = s;
                i++;
            }
        }
        return printResult(result);
    }

    public void add (Searchable searchable){
        if (count == searchables.length) {
            System.out.println("Нет места");
            return;
        }
        searchables[count] = searchable;
        count++;
    }

    public String printResult(Searchable[] searchable){
        StringBuilder s = new StringBuilder();
        for (Searchable search: searchable){
            if (search != null){
                s.append(search).append('\n');
            }
        }
        return s.toString();

    }

    public Searchable bestSearchByTerm (String substr) throws BestResultNotFound {
        int match = 0;
        Searchable searchable = null;
        for (Searchable search: searchables) {
            if(search == null){
                continue;
            }
            int countMatch = search.getSearchTerm(search.getSearchTerm(), substr);
            if (match < countMatch) {
                match = countMatch;
                searchable = search;
            }
        }
        if (searchable == null){
            throw new BestResultNotFound("Для запроса " + substr + " совпадений не найдено.");
        }
        return searchable;
    }

    public Searchable findBestMatch(String searchTerm) {
        return null;
    }
}
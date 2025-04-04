package org.skypro.skyshop;

class BestResultNotFoundException extends Exception {
    public BestResultNotFoundException(String search) {
        super("Не найдено подходящих объектов для запроса: '" + search + "'");
    }
}
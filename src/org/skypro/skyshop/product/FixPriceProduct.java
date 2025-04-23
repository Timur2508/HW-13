package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String title) throws IllegalAccessException {
        super(title);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString(){
        return "Наименование продукта с фиксированной ценой: " + getTitle() + ", Фиксированная цена: " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
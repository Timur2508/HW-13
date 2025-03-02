package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String title){
        super(title);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString(){
        return "Наименование продукта с фиксированной ценой: " + title + ", Фиксированная цена: " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setPrice(double price) {
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String contentType() {
        return "PRODUCT";
    }
}
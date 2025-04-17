package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private static int specialProduct = 0;
    private Map<String, List<Product>> productBasket;

    public ProductBasket() {
        this.productBasket = new HashMap<>();
    }

    private boolean isEmpty(Map<String, List<Product>> productBasket) {
        return productBasket.isEmpty();
    }

    public void addProduct(Product product) {
        String productName = product.getTitle();
        if (!productBasket.containsKey(productName)) {
            productBasket.put(productName, new LinkedList<>());
        }
        productBasket.get(productName).add(product);
    }

    public int getAllPrice() {
        int allPrice = 0;
        for (List<Product> products : productBasket.values()) {
            for (Product product : products) {
                if (product != null) {
                    allPrice += product.getPrice();
                }
            }
        }
        return allPrice;
    }

    public void printMyBasket() {
        if (isEmpty(productBasket)) {
            System.out.println("Корзина пуста.");
            return;
        }
        specialProduct = 0;
        for (List<Product> products : productBasket.values()) {
            for (Product product : products) {
                if (product != null && product.isSpecial()) {
                    specialProduct++;
                    System.out.println(product);
                } else {
                    System.out.println(product);
                }
            }
        }
        System.out.println("Итого: " + getAllPrice());
        System.out.println("Специальных товаров: " + specialProduct);
    }

    public boolean isNoProductInBasket(String productName) {
        return !productBasket.containsKey(productName);
    }

    public void clearBasket() {
        if (isEmpty(productBasket)) {
            System.out.println("Корзина пуста.");
        }
        productBasket.clear();
        System.out.println("Корзина очищена.");
    }

    public List<Product> removeAllProductsNamedBy(String name) {
        List<Product> removedProducts = new ArrayList<>();
        if (productBasket.containsKey(name)) {
            removedProducts.addAll(productBasket.remove(name));
        } else {
            System.out.println("Нет продуктов с именем '" + name + "' в корзине.");
        }
        return removedProducts;
    }

    public void printBasket() {
    }

    public void checkBasket(String productName) {
        System.out.println("Проверяем наличие продукта '" + productName + "' в корзине...");
    }
}
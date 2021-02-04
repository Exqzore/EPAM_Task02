package by.epam.shop.repository;

import by.epam.shop.entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    private static final ProductRepository instance = new ProductRepository();

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        return instance;
    }

    public int size() {
        return products.size();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addAll(Collection<? extends Product> c) {
        products.addAll(c);
    }

    public Product get(int index) {
        return products.get(index);
    }
}

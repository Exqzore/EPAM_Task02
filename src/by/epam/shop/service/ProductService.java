package by.epam.shop.service;

import by.epam.shop.entity.Product;
import by.epam.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final ProductRepository productRepository = ProductRepository.getInstance();

    public List<Product> findByName(String productName) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productRepository.size(); i++) {
            Product product = productRepository.get(i);
            if (product.getName().equals(productName)) {
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> findCheapest() {
        List<Product> products = new ArrayList<>();
        if(!productRepository.isEmpty()) {
            Product product = productRepository.get(0);
            for(int i = 1; i < productRepository.size(); i++) {
                Product tempProduct = productRepository.get(i);
                if (product.getPrice() > tempProduct.getPrice()) {
                    product = tempProduct;
                }
            }
            for (int i = 1; i < productRepository.size(); i++) {
                Product tempProduct = productRepository.get(i);
                if (product.getPrice() == tempProduct.getPrice()) {
                    products.add(tempProduct);
                }
            }
        }
        return products;
    }
}
package by.epam.shop;

import by.epam.shop.entity.Product;
import by.epam.shop.exception.ReaderException;
import by.epam.shop.parser.ProductParser;
import by.epam.shop.reader.FileReader;
import by.epam.shop.repository.ProductRepository;
import by.epam.shop.service.ProductService;

import java.util.List;

public class ProjectRunner {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        ProductParser productParser = new ProductParser();
        ProductService productService = new ProductService();
        try {
            String dataString = fileReader.read("resources/shop_db.txt");
            ProductRepository.getInstance().addAll(productParser.parseProducts(dataString));
        } catch (ReaderException e) {
            System.out.println(e.getMessage()); //TODO: change to logger
        }
        List<Product> products = productService.findByName("Refrigerator");
        for (Product product : products) {
            System.out.println(product.toString());
        }
        List<Product> CheapestProducts = productService.findCheapest();
        for (Product product : CheapestProducts) {
            System.out.println(product.toString());
        }
    }
}

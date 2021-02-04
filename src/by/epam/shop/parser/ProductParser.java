package by.epam.shop.parser;

import by.epam.shop.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductParser {
    private static final String PRODUCT_DELIMITER = "\n";
    private static final String PRODUCT_NAME_DELIMITER = " : ";
    private static final String PRODUCT_PARAMETERS_DELIMITER = ", ";
    private static final String KEY_VALUE_DELIMITER = "=";

    public List<Product> parseProducts(String dataString) {
        List<Product> products = new ArrayList<>();
        String[] parts = dataString.split(PRODUCT_DELIMITER);
        for (String part : parts) {
            if (part.length() <= 1) {
                continue;
            }
            String[] productCharacteristics = part.split(PRODUCT_NAME_DELIMITER);
            String productName = productCharacteristics[0];
            String[] characteristics = productCharacteristics[1].split(PRODUCT_PARAMETERS_DELIMITER);
            Map<String, String> parameters = new HashMap<>();
            for (String characteristic : characteristics) {
                String[] parameter = characteristic.split(KEY_VALUE_DELIMITER);
                parameters.put(parameter[0], parameter[1]);
            }
            products.add(new Product(productName, parameters));
        }
        return products;
    }
}

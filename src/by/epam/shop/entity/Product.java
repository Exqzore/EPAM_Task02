package by.epam.shop.entity;

import java.util.Map;

public class Product {
    private final String name;
    private final Map<String, String> parameters;

    public Product(String name, Map<String, String> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return Float.parseFloat(parameters.get("PRICE"));
    }

    public void setPrice(Float price) {
        parameters.put("PRICE", price.toString());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("name='").append(name).append("'");
        sb.append(", parameters=").append(parameters);
        sb.append('}');
        return sb.toString();
    }
}

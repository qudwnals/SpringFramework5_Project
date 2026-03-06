// 2. ShoppingCart.java
package mylab.order.entity;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {}

    // Getter and Setter
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
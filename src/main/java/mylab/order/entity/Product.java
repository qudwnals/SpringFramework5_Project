// 1. Product.java
package mylab.order.entity;

public class Product {
    private String id;
    private String name;
    private int price;

    // 기본 생성자 (Setter Injection에 필수)
    public Product() {}

    // 매개변수가 있는 생성자 (Constructor Injection에 필수)
    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
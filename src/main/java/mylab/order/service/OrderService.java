// 3. OrderService.java
package mylab.order.service;

import mylab.order.entity.ShoppingCart;

public class OrderService {
    private ShoppingCart shoppingCart;

    public OrderService() {}

    // OrderService는 ShoppingCart에 의존하므로 Setter를 열어둡니다.
    public ShoppingCart getShoppingCart() { return shoppingCart; }
    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }
}
package mylab.order.test;

import mylab.order.entity.ShoppingCart;
import mylab.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// 1. 스프링 테스트 환경을 구동하고, 작성한 XML 파일을 설정으로 읽어옵니다.
@ExtendWith(SpringExtension.class) // JUnit 5 기준
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    // 2. ShoppingCart 클래스와 OrderService 클래스를 Injection(주입) 받으세요.
    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private OrderService orderService;

    // 3. ShoppingCart 스프링 Bean을 테스트 하는 메서드
    @Test
    void testShoppingCart() {
        // - shoppingCart 객체가 Null 이 아닌지 검증
        assertNotNull(shoppingCart, "shoppingCart 객체는 Null이 아니어야 합니다.");

        // - shoppingCart.getProducts().size() 를 검증
        assertEquals(2, shoppingCart.getProducts().size(), "장바구니에는 2개의 상품이 있어야 합니다.");

        // - shoppingCart.getProducts().get(0).getName() 이 "노트북" 인지 검증
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName());

        // - shoppingCart.getProducts().get(1).getName() 이 "스마트폰" 인지 검증
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
    }

    // 4. OrderService 스프링 Bean을 테스트 하는 메서드
    @Test
    void testOrderService() {
        // - orderService 객체가 Null 이 아닌지 검증
        assertNotNull(orderService, "orderService 객체는 Null이 아니어야 합니다.");

        // - OrderService에 주입된 shoppingCart 객체가 Null 이 아닌지 검증 (의존성 주입 확인)
        assertNotNull(orderService.getShoppingCart(), "OrderService 내부에 shoppingCart가 주입되어야 합니다.");

        // - 주입된 ShoppingCart를 통해 내부 데이터가 똑같이 유지되는지 검증
        assertEquals(2, orderService.getShoppingCart().getProducts().size());
        assertEquals("노트북", orderService.getShoppingCart().getProducts().get(0).getName());
    }
}
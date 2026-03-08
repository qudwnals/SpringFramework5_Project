package mylab.user.test;

import mylab.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testUserServiceDependencyInjectionAndRegister() {
        assertNotNull(userService, "UserService Bean은 null이면 안 됩니다.");
        assertNotNull(userService.getUserRepository(), "UserRepository가 주입되어야 합니다.");
        assertEquals("MySQL", userService.getUserRepository().getDbType(), "DB 타입은 MySQL이어야 합니다.");
        assertNotNull(userService.getSecurityService(), "SecurityService가 주입되어야 합니다.");
        assertTrue(userService.registerUser(), "registerUser()는 true를 반환해야 합니다.");
    }
}

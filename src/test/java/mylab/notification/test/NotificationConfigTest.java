package mylab.notification.test;

import mylab.notification.config.NotificationConfig;
import mylab.notification.service.EmailNotificationService;
import mylab.notification.service.NotificationManager;
import mylab.notification.service.SmsNotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(NotificationConfig.class)
public class NotificationConfigTest {

    // Java Config 기반으로 생성된 NotificationManager 주입
    @Autowired
    private NotificationManager notificationManager;

    @Test
    void testNotificationManagerWithJavaConfig() {
        // 1) NotificationManager Bean 생성 확인
        assertNotNull(notificationManager, "NotificationManager Bean은 null이면 안 됩니다.");

        // 2) Email 서비스 주입/설정값 검증
        EmailNotificationService emailService = notificationManager.getEmailService();
        assertNotNull(emailService, "EmailNotificationService가 주입되어야 합니다.");
        assertEquals("smtp.gmail.com", emailService.getSmtpServer());
        assertEquals(587, emailService.getPort());

        // 3) SMS 서비스 주입/설정값 검증
        SmsNotificationService smsService = notificationManager.getSmsService();
        assertNotNull(smsService, "SmsNotificationService가 주입되어야 합니다.");
        assertEquals("SKT", smsService.getProvider());

        // 4) NotificationManager의 위임 메서드 실행 검증
        assertDoesNotThrow(() -> notificationManager.sendNotificationByEmail("테스트 이메일"));
        assertDoesNotThrow(() -> notificationManager.sendNotificationBySms("테스트 SMS"));
    }
}

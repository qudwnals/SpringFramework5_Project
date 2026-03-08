package mylab.notification.config;

import mylab.notification.service.EmailNotificationService;
import mylab.notification.service.NotificationManager;
import mylab.notification.service.SmsNotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    // 이메일 알림 Bean: SMTP 설정 포함
    @Bean
    public EmailNotificationService emailNotificationService() {
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    // SMS 알림 Bean: 통신사/제공업체 설정
    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("SKT");
    }

    // NotificationManager Bean: 이메일/SMS 서비스를 생성자 주입
    @Bean
    public NotificationManager notificationManager(EmailNotificationService emailNotificationService,
                                                   SmsNotificationService smsNotificationService) {
        return new NotificationManager(emailNotificationService, smsNotificationService);
    }
}

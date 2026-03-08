package mylab.notification.config;

import mylab.notification.service.EmailNotificationService;
import mylab.notification.service.NotificationManager;
import mylab.notification.service.SmsNotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager(EmailNotificationService emailNotificationService,
                                                   SmsNotificationService smsNotificationService) {
        return new NotificationManager(emailNotificationService, smsNotificationService);
    }
}

package mylab.notification.service;

public class NotificationManager {
	
	 // 이메일/SMS 서비스를 중앙에서 관리하기 위한 의존성
    private final EmailNotificationService emailService;
    private final SmsNotificationService smsService;

    public NotificationManager(EmailNotificationService emailService, SmsNotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public EmailNotificationService getEmailService() {
        return emailService;
    }

    public SmsNotificationService getSmsService() {
        return smsService;
    }

    public void sendNotificationByEmail(String message) {
    	// 이메일 서비스로 위임
    	emailService.sendNotification(message);
    }

    public void sendNotificationBySms(String message) {
    	 // SMS 서비스로 위임
    	smsService.sendNotification(message);
    }
}

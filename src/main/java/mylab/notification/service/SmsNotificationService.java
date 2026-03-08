package mylab.notification.service;

public class SmsNotificationService implements NotificationService {
	
	 // 생성자 주입으로 받는 SMS 제공업체 정보
    private final String provider;

    public SmsNotificationService(String provider) {
    
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public void sendNotification(String message) {
    	 // 실제 연동 대신 콘솔 출력으로 동작 확인
        System.out.println("[SMS] " + message + " (Provider: " + provider + ")");
    }
}

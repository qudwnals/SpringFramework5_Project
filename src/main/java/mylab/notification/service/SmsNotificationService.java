package mylab.notification.service;

public class SmsNotificationService implements NotificationService {

    private final String provider;

    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS] " + message + " (Provider: " + provider + ")");
    }
}

package mylab.notification.service;

public class EmailNotificationService implements NotificationService {

    private final String smtpServer;
    private final int port;

    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public int getPort() {
        return port;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[Email] " + message + " (SMTP: " + smtpServer + ":" + port + ")");
    }
}

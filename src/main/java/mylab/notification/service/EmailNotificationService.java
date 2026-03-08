package mylab.notification.service;

public class EmailNotificationService implements NotificationService {
	
	// 생성자 주입으로 받는 이메일 서버 설정값
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
    	// 실제 연동 대신 콘솔 출력으로 동작 확인
        System.out.println("[Email] " + message + " (SMTP: " + smtpServer + ":" + port + ")");
    }
}

package mylab.user.service;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {
	
	 // 인증 로직 예시: 공백이 아닌 사용자명만 통과
    public boolean authenticate(String username) {
        return username != null && !username.trim().isEmpty();
    }
}

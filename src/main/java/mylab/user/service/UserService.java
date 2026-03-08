package mylab.user.service;

import mylab.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	
	// 필드 주입: XML component-scan으로 등록된 UserRepository Bean 자동 주입
    @Autowired
    private UserRepository userRepository;
    
    // 필드 주입: 인증 담당 SecurityService Bean 자동 주입
    @Autowired
    private SecurityService securityService;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }
    
    // 실습 요구사항의 사용자 등록 시나리오: 인증 후 저장
    public boolean registerUser() {
        String username = "spring-user";
        if (!securityService.authenticate(username)) {
            return false;
        }
        return userRepository.saveUser(username);
    }
}

package mylab.user.service;

import mylab.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }

    public boolean registerUser() {
        String username = "spring-user";
        if (!securityService.authenticate(username)) {
            return false;
        }
        return userRepository.saveUser(username);
    }
}

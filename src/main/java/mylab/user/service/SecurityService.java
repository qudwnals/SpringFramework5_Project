package mylab.user.service;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    public boolean authenticate(String username) {
        return username != null && !username.trim().isEmpty();
    }
}

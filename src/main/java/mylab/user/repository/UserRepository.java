package mylab.user.repository;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private final String dbType = "MySQL";

    public String getDbType() {
        return dbType;
    }

    public boolean saveUser(String username) {
        return username != null && !username.trim().isEmpty();
    }
}

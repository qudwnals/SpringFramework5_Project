package mylab.user.repository;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    // 실습 요구사항: DB 타입 검증용 고정 값
    private final String dbType = "MySQL";

    public String getDbType() {
        return dbType;
    }

    // 사용자 저장 동작을 단순화한 메서드(유효한 이름이면 저장 성공으로 처리)
    public boolean saveUser(String username) {
        return username != null && !username.trim().isEmpty();
    }
}

package Lottery;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void canCreateUser() { // 의미없는 테스트
        int userId = 100;
        User user = new User(100, "nametest");
        assertEquals(user.getUserId(), userId);
    }
}

package Lottery;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    private Point point;

    @Before
    public void setUp(){
        point = new Point();
    }

    @Test
    public void canDepositUsersPoint() {
        // Arrange
        User user = new User(100, "username");

        // Act
        int pointToDeposit = 150;
        point.deposit(user.getUserId(), pointToDeposit);

        // Assert
        assertEquals(pointToDeposit, point.getUserPoint(user.getUserId()));
    }

    @Test
    public void canWithdrawUsersPoint() {
        // Arrange
        User user = new User(101, "username");

        // Act
        int pointToDeposit = 200;
        int pointToWithdraw = 100;
        point.deposit(user.getUserId(), pointToDeposit);
        point.withdraw(user.getUserId(), pointToWithdraw);

        // Assert
        assertEquals(pointToDeposit - pointToWithdraw, point.getUserPoint(user.getUserId()));
    }

    @Test(expected = RuntimeException.class)
    public void cannotWithdrawMoreThanUserHas() {
        // Arrange
        User user = new User(101, "username");

        // Act
        int pointToDeposit = 200;
        int pointToWithdraw = 400;
        point.deposit(user.getUserId(), pointToDeposit);
        point.withdraw(user.getUserId(), pointToWithdraw);

        // Assert
    }

}

package Lottery;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointServiceTest {
    private PointService point;

    @Before
    public void setUp(){
        point = new PointService();
    }

    @Test
    public void A_유저는_포인트서비스로_포인트를_예금할_수_있다() {
        // Arrange
        final Long pointToDeposit = 150L;
        final User user = new User(100L, "username");

        // Act
        point.deposit(user.getId(), pointToDeposit);

        // Assert
        assertEquals(pointToDeposit, point.getUserPoint(user.getId()));
    }

    @Test
    public void B_유저는_포인트서비스로_포인트를_인출할_수_있다() {
        // Arrange
        final Long pointToDeposit = 200L;
        final Long pointToWithdraw = 100L;
        final Long difference = pointToDeposit - pointToWithdraw;
        User user = new User(101L, "username");

        // Act
        point.deposit(user.getId(), pointToDeposit);
        point.withdraw(user.getId(), pointToWithdraw);

        // Assert
        assertEquals(difference, point.getUserPoint(user.getId()));
    }

    @Test(expected = RuntimeException.class)
    public void C_유저는_포인트서비스로_예금액보다_많은_금액을_인출할_수_없다() {
        // Arrange
        final Long pointToWithdraw = 400L;
        final Long pointToDeposit = 200L;
        User user = new User(101L, "username");

        // Act
        point.deposit(user.getId(), pointToDeposit);
        point.withdraw(user.getId(), pointToWithdraw);

        // Assert
        assertTrue(true);
    }

}

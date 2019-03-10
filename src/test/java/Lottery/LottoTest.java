package Lottery;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LottoTest {

    private Lotto lotto;

    @Test
    public void canCreateLotto() {
        User user = new User(1, "name");
        lotto = new Lotto(user.getUserId());
    }

    @Test
    public void canGenerateListOfNumbers() {
        // Arrange
        User user = new User(1, "name");
        lotto = new Lotto(user.getUserId());

        // Act
        ArrayList<LottoSet> list = lotto.generate(3);

        // Assert
    }

    @Test
    public void canGenerateListOfGivenAmount() {
        // Arrange
        User user = new User(1, "name");
        lotto = new Lotto(user.getUserId());

        // Act
        int amount = 3;
        ArrayList<LottoSet> list = lotto.generate(amount);

        // Assert
        assertEquals(amount, list.size());
    }

    @Test
    public void eachListHas6NumbersInIt() {
        // Arrange
        User user = new User(1, "name");
        lotto = new Lotto(user.getUserId());

        // Act
        int amount = 3;
        ArrayList<LottoSet> list = lotto.generate(amount);

        // Assert
        for (LottoSet lottoSet : list) {
            assertEquals(6, lottoSet.size());
        }
    }

    @Ignore
    @Test
    public void canRetrieveUsersPoint() {
        // Arrange
        User user = new User(1, "name");
        Point point = new Point();
        point.deposit(user.getUserId(), 350);

        lotto = new Lotto(user.getUserId());

        // Act


        // Assert

    }
}
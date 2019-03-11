package Lottery;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LottoLotteryServiceTest {
    private LotteryService lottery;

    @Before
    public void setUp() {
        lottery = new LottoLotteryServiceImpl();
    }

    @Test
    public void A_유저는_로또_복권을_생성할_수_있다() {
        // Arrange

        // Act
        Lottery lotto = lottery.createLottery();

        // Assert
        assertNotNull(lotto);
    }

    @Test
    public void B_생성된_로또_번호는_6개가_생성되어야_한다() {
        // Arrange

        // Act
        Lottery lotto = lottery.createLottery();

        // Assert
        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    public void C_생성된_로또_번호는_중복이_없어야_한다() {
        // Arrange

        // Act
        Lottery lotto = lottery.createLottery();

        // Assert
        List<Integer> lottoNumbers = lotto.getNumbers();
        Set<Integer> resultSet = new HashSet<>(lottoNumbers);

        assertEquals(lottoNumbers.size(), resultSet.size());
    }

    @Test
    public void D_생성된_로또_번호는_1과_45_사이의_숫자여야_한다() {
        // Arrange

        // Act
        Lottery lotto = lottery.createLottery();

        // Assert
        List<Integer> numbers = lotto.getNumbers();
        numbers.forEach(number -> assertTrue(number >= 1 && number <= 45));
    }

    @Test
    public void E_주어진_세트_수_만큼의_로또가_생성되어야_한다() {
        // Arrange
        final int setCount = 5;

        // Act
        List<Lottery> lottos = lottery.createLotteries(setCount);

        // Assert
        assertEquals(lottos.size(), setCount);
    }
}

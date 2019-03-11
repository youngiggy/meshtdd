package Lottery;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoLotteryServiceTest {
    private LotteryService lottery;

    @Before
    public void setUp() {
        lottery = new LottoLotteryServiceImpl();
    }

    @Test
    public void 생성된_로또_번호는_6개가_생성되어야_한다() {
        Lottery lotto = lottery.createLottery();
        assertEquals(lotto.getNumbers().size(), 6);
    }

    @Test
    public void 생성된_로또_번호는_중복이_없어야_한다() {
        Lottery lotto = lottery.createLottery();
        List<Integer> lottoNumbers = lotto.getNumbers();
        Set<Integer> resultSet = new HashSet<>(lottoNumbers);

        assertEquals(resultSet.size(), lottoNumbers.size());
    }

    @Test
    public void 생성된_로또_번호는_1과_45_사이의_숫자여야_한다() {
        Lottery lotto = lottery.createLottery();
        List<Integer> numbers = lotto.getNumbers();
        numbers.forEach(number -> assertTrue(number >= 1 && number <= 45));
    }

    @Test
    public void 주어진_세트_수_만큼의_로또가_생성되어야_한다() {
        final int setCount = 5;
        List<Lottery> lottos = lottery.createLotteries(setCount);
        assertEquals(lottos.size(), setCount);
    }
}

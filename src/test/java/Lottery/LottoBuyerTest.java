package Lottery;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LottoBuyerTest {
    private LotteryBuyer lottoBuyer;

    @Before
    public void setUp() {
        User user = new User(1, "테스트유저");
        lottoBuyer = new LottoLotteryBuyer(user);
    }

    @Test
    public void A_최초_유저는_500_포인트를_가진다() {
        assertEquals(lottoBuyer.getCurrentBuyerPoint(), 500);
    }

    @Test
    public void B_유저는_포인트를_충전할_수_있다() {
        int existedPoint = lottoBuyer.getCurrentBuyerPoint();
        final int withdrawPoint = 1000;

        lottoBuyer.depositBuyerPoint(withdrawPoint);

        assertEquals(withdrawPoint - existedPoint, 500);
    }

    @Test
    public void C_유저는_원하는_만큼의_복권을_구입할_수_있다() {
        final int buyCount = 5;
        int existedLotteryCount = lottoBuyer.getLotteries().size();
        lottoBuyer.buyLotteries(buyCount);

        assertEquals(lottoBuyer.getLotteries().size() - existedLotteryCount, buyCount);
    }

    @Test
    public void D_복권을_구입하면_개당_100의_포인트가_차감된다() {
        final int buyCount = 5;
        int existedPoint = lottoBuyer.getCurrentBuyerPoint();
        lottoBuyer.buyLotteries(buyCount);

        assertEquals(existedPoint - lottoBuyer.getCurrentBuyerPoint(), 500);
    }

    @Test(expected = RuntimeException.class)
    public void E_복권_구입_시_포인트가_부족한_경우_예외가_발생한다() {
        final int buyCount = 100;
        lottoBuyer.buyLotteries(buyCount);
    }
}

package Lottery;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LottoBuyerTest {

    final Long initialPoint = 500L;

    @Test
    public void A_최초_유저는_500_포인트를_가진다() {
        // Arrage

        // Act
        LotteryBuyer lottoBuyer = new LottoLotteryBuyer(1L, "테스트유저");

        // Assert
        assertEquals(initialPoint, lottoBuyer.getCurrentPoint());
    }

    @Test
    public void B_유저는_포인트를_충전할_수_있다() {

        // Arrage
        final Long withdrawPoint = 1000L;
        LotteryBuyer lottoBuyer = new LottoLotteryBuyer(1L, "테스트유저");

        // Act
        Long existedPoint = lottoBuyer.getCurrentPoint();
        lottoBuyer.depositBuyerPoint(withdrawPoint);

        // Assert
        assertEquals(withdrawPoint - existedPoint, 500);
    }

    @Test
    public void C_유저는_원하는_만큼의_복권을_구입할_수_있다() {
        // Arrage
        final int buyCount = 5;
        LotteryBuyer lottoBuyer = new LottoLotteryBuyer(1L, "테스트유저");

        // Act
        int existedLotteryCount = lottoBuyer.getLotteries().size();
        lottoBuyer.buyLotteries(buyCount);

        // Assert
        assertEquals(existedLotteryCount + buyCount, lottoBuyer.getLotteries().size());
    }

    @Test
    public void D_복권을_구입하면_개당_100의_포인트가_차감된다() {
        // Arrage
        final int buyCount = 5;
        LotteryBuyer lottoBuyer = new LottoLotteryBuyer(1L, "테스트유저");

        // Act
        Long existedPoint = lottoBuyer.getCurrentPoint();
        lottoBuyer.buyLotteries(buyCount);

        // Assert
        Long expectedPoint = existedPoint - 500L;
        assertEquals(expectedPoint, lottoBuyer.getCurrentPoint());
    }

    @Test(expected = RuntimeException.class)
    public void E_복권_구입_시_포인트가_부족한_경우_예외가_발생한다() {
        // Arrage
        final int buyCount = 100;
        LotteryBuyer lottoBuyer = new LottoLotteryBuyer(1L, "테스트유저");

        // Act
        lottoBuyer.buyLotteries(buyCount);
    }
}

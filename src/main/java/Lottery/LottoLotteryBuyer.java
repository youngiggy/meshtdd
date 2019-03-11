package Lottery;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class LottoLotteryBuyer extends User implements LotteryBuyer {

    private final Long LOTTERY_PRICE = 100L;

    private PointService wallet = new PointService();
    private List<Lottery> lotteries = new ArrayList<>();

    private LotteryService lotteryService = new LottoLotteryServiceImpl();

    LottoLotteryBuyer(Long userId, String username) {
        super(userId, username);
        wallet.deposit(this.getId(), 500L);
    }

    @Override
    public void depositBuyerPoint(Long point) {
        wallet.deposit(this.getId(), point);
    }

    @Override
    public void buyLotteries(int count) {
        lotteries.addAll(lotteryService.createLotteries(count));
        wallet.withdraw(this.getId(), count * LOTTERY_PRICE);
    }

    @Override
    public Long getCurrentPoint() {
        return wallet.getUserPoint(this.getId());
    }
}

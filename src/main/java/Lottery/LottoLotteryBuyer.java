package Lottery;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class LottoLotteryBuyer implements LotteryBuyer {

    private final int LOTTERY_PRICE = 100;

    private User buyer;
    private Point wallet = new Point();
    private List<Lottery> lotteries = new ArrayList<>();

    private LotteryService lotteryService = new LottoLotteryServiceImpl();

    public LottoLotteryBuyer(User buyer) {
        this.buyer = buyer;
        wallet.deposit(buyer.getUserId(), 500);
    }

    @Override
    public void depositBuyerPoint(int point) {
        wallet.deposit(buyer.getUserId(), point);
    }

    @Override
    public void buyLotteries(int count) {
        lotteries.addAll(lotteryService.createLotteries(count));
        wallet.withdraw(buyer.getUserId(), count * LOTTERY_PRICE);
    }

    @Override
    public int getCurrentBuyerPoint() {
        return wallet.getUserPoint(buyer.getUserId());
    }
}

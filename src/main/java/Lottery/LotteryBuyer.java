package Lottery;

import java.util.List;

public interface LotteryBuyer {
    Long getCurrentPoint();
    void depositBuyerPoint(Long point);
    void buyLotteries(int count);

    List<Lottery> getLotteries();
}

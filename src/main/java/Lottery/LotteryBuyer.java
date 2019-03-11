package Lottery;

import java.util.List;

public interface LotteryBuyer {

    User getBuyer();
    void setBuyer(User buyer);
    int getCurrentBuyerPoint();
    void depositBuyerPoint(int point);
    void buyLotteries(int count);

    List<Lottery> getLotteries();
}

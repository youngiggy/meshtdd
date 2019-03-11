package Lottery;

import java.util.List;

public interface LotteryService {
    Lottery createLottery();
    List<Lottery> createLotteries(int count);
}

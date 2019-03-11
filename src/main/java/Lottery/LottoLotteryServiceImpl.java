package Lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoLotteryServiceImpl implements LotteryService {

    private final int TOTAL_NUMBER_COUNT = 45;
    private final int GENERATED_NUMBER_COUNT = 6;

    private List<Integer> lotteryBalls;

    LottoLotteryServiceImpl() {
        lotteryBalls = new ArrayList<>();
        for (int i = 1; i <= TOTAL_NUMBER_COUNT; i++) {
            lotteryBalls.add(i);
        }
    }

    @Override
    public Lottery createLottery() {
        List<Integer> numbers = generateLottoNumbers();
        return new LottoLottery(numbers);
    }

    public List<Lottery> createLotteries(int count) {
        List<Lottery> lotteries = new ArrayList<>();

        for(int i=0; i<count; i++) {
            lotteries.add(createLottery());
        }

        return lotteries;
    }

    private List<Integer> generateLottoNumbers() {
        Collections.shuffle(lotteryBalls);
        return lotteryBalls.subList(0, GENERATED_NUMBER_COUNT);
    }
}

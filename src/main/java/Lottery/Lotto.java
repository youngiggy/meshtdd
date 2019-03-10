package Lottery;

import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    private int userId;

    Lotto(int userId) {
        this.userId = userId;
    }

    public ArrayList<LottoSet> generate(int setAmount) {
        ArrayList<LottoSet> newList = new ArrayList<>();
        for (int i = 0; i < setAmount; i++)
            newList.add(generateSingleLottoSet());

        return newList;
    }

    private LottoSet generateSingleLottoSet() {
        LottoSet lottoSet = new LottoSet();

        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            lottoSet.addNumber(rand.nextInt(45) + 1);
        }

        return lottoSet;
    }
}

package Lottery;

import java.util.ArrayList;

public class LottoSet {
    ArrayList<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    public int size() {
        return numbers.size();
    }
}

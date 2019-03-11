package Lottery;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
class LottoLottery implements Lottery {
    private List<Integer> numbers;

    LottoLottery(List<Integer> numbers) {
        this.numbers = numbers;
    }
}

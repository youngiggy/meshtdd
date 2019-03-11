package Lottery;

public class Main {

    public static void main (String[] args)
    {
        // New lottery service hered
        LotteryBuyer lotteryService = new LottoLotteryBuyer(1L, "userNo1");
        lotteryService.buyLotteries(5);

        // End to end test
        System.out.printf("user has %d points now.", lotteryService.getCurrentPoint());
    }
}

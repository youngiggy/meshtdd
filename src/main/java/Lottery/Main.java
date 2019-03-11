package Lottery;

public class Main {

    public static void main (String[] args)
    {
        User user = new User(1, "userNo1");

        // New lottery service hered
        LotteryBuyer lotteryService = new LottoLotteryBuyer(user);
        lotteryService.buyLotteries(5);

        // End to end test
        System.out.printf("user has %d points now.", lotteryService.getCurrentBuyerPoint());
    }
}

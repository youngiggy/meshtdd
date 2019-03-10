package Lottery;

public class Main {

    public static void main (String[] args)
    {
        User user = new User(1, "userNo1");
        Point pointService = new Point();
        pointService.deposit(user.getUserId(), 350);

        // New lottery service hered


        // End to end test
        System.out.printf("user has %d points now.", pointService.getUserPoint(user.getUserId()));
    }
}

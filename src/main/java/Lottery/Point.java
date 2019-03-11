package Lottery;

import java.util.HashMap;

public class Point {
    private HashMap<Integer, Integer> users = new HashMap<>();

    public int getUserPoint(int userID) {
        return users.get(userID);
    }

    public void deposit(int userID, int point) {
        users.put(userID, point);
    }

    public void withdraw(int userID, int point) {
        int previousPoint = getUserPoint(userID);

        if (previousPoint < point) {
            throw new RuntimeException("cannot withdraw more than user has");
        }

        users.put(userID, previousPoint - point);
    }
}

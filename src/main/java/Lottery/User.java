package Lottery;

public class User {
    private int id;
    private String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getUserId() {
        return id;
    }
}

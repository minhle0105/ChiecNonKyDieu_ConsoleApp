package model;

public class Player {
    private String username;
    private int score;

    public Player(String username) {
        this.username = username;
        this.score = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    @Override
    public String toString() {
        return "Player " +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}

package ru.myitschool.appkhl.model;


public class Player {
    private String fullName;
    private String nameClub;
    private long score;
    private boolean like;

    public String getFullName() {
        return fullName;
    }

    public String getNameClub() {
        return nameClub;
    }

    public long getScore() {
        return score;
    }

    public boolean isLike() {
        return like;
    }

    //конструктор поумолчанию
    public Player() {
        this.fullName = "unknown";
        this.nameClub = "unknown";
        this.score = 0;
        this.like = false;
    }

    //параметрический конструктор
    public Player(String fullName, String nameClub, long score,
                    boolean like) {
        this.fullName = fullName;
        this.nameClub = nameClub;
        this.score = score;
        this.like = like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}

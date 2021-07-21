package com.company;

public class Player {
    public String name;
    public Cup cup = new Cup();
    public int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public int updateScore() {
        int roundScore = 0;
        for (Die die : cup.dice) {
            roundScore += die.faceUpValue;
        }
        score += roundScore;
        return roundScore;
    }

}

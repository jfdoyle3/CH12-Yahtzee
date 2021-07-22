package com.company;

import java.util.Scanner;

public class Yahtzee {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE_UNDERLINED = "\033[4;34m";
    public static final String ANSI_GREEN_BOLD = "\033[1;32m";
    public static final String ANSI_BLACK_BOLD = "\033[1;30m";
    public static final String ANSI_GREEN_UNDERLINED = "\033[4;32m";


    //    public Cup myCup = new Cup();
    public Player player;
    private final Scanner scanner = new Scanner(System.in);
    private int totalScore = 0;
    private int finalScore = 0;

    public Yahtzee() {
        System.out.println("What is your name?");
        player = new Player((scanner.nextLine()).trim());
    }

    // TODO refactor play to run 5 turns then display total score.
    public void play() {

        for (int round = 1; round <= 5; round++) {
            System.out.println(ANSI_BLUE_UNDERLINED + "\nRound: " + round + ANSI_RESET);
            int score = turn(round);
            finalScore += score;

        }
        System.out.println(ANSI_GREEN_BOLD + "\n\t\t  Final Score: \t" +ANSI_BLACK_BOLD+ finalScore + ANSI_RESET);
    }

    public void getSelections() {
        System.out.println("select dice you want to re-roll (1-5)");
        String input = scanner.nextLine(); // "1 2 5"
        player.cup.roll(player.cup.parseSelections(input));
    }

    // TODO refactor turn to update score and display round score *(and total score)
    public int turn(int round) {
        player.cup.roll();

        for (int i = 0; i < 2; i++) {
            System.out.println(ANSI_BLACK_BOLD + player.cup.displayCup() + ANSI_RESET);
            getSelections();
        }
        int score = player.updateScore();

        System.out.println(ANSI_BLACK_BOLD + player.cup.displayCup() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "\t    Round " + round + " Score:" + ANSI_RESET + "\t" + score);
        totalScore += score;
        System.out.println("\t" + ANSI_GREEN_UNDERLINED + "Round Score Total:" + ANSI_RESET + "\t" + totalScore);
        return totalScore;

    }
}

package model;

import java.util.*;

public class Game {
    private Player player1;
    private Player player2;
    private char[] keyWord;
    private char[] currentWord;

    private int winnerId;
    Map<Character, List<Integer>> map;
    boolean isPlayer1Turn;

    public int getWinnerId() {
        return winnerId;
    }

    public Game(Player player1, Player player2, char[] keyWord) {
        this.player1 = player1;
        this.player2 = player2;
        this.keyWord = keyWord;
        this.currentWord = new char[keyWord.length];
        Arrays.fill(currentWord, '_');
        this.map = new HashMap<>();
        for (int i = 0; i < keyWord.length; i++) {
            if (!map.containsKey(keyWord[i])) {
                map.put(keyWord[i], new ArrayList<>());
            }
            map.get(keyWord[i]).add(i);
        }
        this.isPlayer1Turn = true;
        this.winnerId = -1;
    }

    public void guess(char playerGuess) {
        if (!map.containsKey(playerGuess)) {
            this.isPlayer1Turn = !this.isPlayer1Turn;
            displayCurrentWord();

        }
        else {
            for (Integer index : map.get(playerGuess)) {
                currentWord[index] = playerGuess;
            }
            if (this.isPlayer1Turn) {
                player1.increaseScore(map.get(playerGuess).size());
            }
            else {
                player2.increaseScore(map.get(playerGuess).size());
            }
            displayCurrentWord();
            this.winnerId = this.hasWinner();
        }
    }

    public void displayTurn() {
        String turn = this.isPlayer1Turn ? "Player 1 guessing next: " : "Player 2 guessing next: ";
        System.out.println(turn);
    }

    public void displayCurrentWord() {
        for (char c : this.currentWord) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public int hasWinner() {
        if (player1.getScore() == this.keyWord.length) {
            return 1;
        }
        if (player2.getScore() == this.keyWord.length) {
            return 2;
        }
        if (Arrays.toString(this.keyWord).equals(Arrays.toString(this.currentWord))) {
            if (player1.getScore() < player2.getScore()) {
                return 2;
            }
            if (player1.getScore() > player2.getScore()) {
                return 1;
            }
            if (player1.getScore() == player1.getScore()) {
                return 0;
            }

        }
        return -1;
    }
}


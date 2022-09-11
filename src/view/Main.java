package view;

import controller.GameController;
import model.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player 1 name: ");
        String player1Username = sc.nextLine();
        Player player1 = new Player(player1Username);
        System.out.println("Enter player 2 name: ");
        String player2Username = sc.nextLine();
        Player player2 = new Player(player2Username);
        System.out.println("Enter keyword (non case-sensitive): ");
        String keyWord = sc.nextLine();
        keyWord = keyWord.toLowerCase();
        GameController gameController = new GameController(player1, player2, keyWord);
        while (true) {
            System.out.println("Enter your guess: ");
            String userGuess = sc.nextLine();
            int res = gameController.play(userGuess.charAt(0));
            if (res == 0) {
                System.out.println(player1);
                System.out.println(player2);
                System.out.println("Game Tied");
                break;
            }
            if (res != -1) {
                System.out.println(player1);
                System.out.println(player2);
                System.out.println("Player " + res + " wins!");
                break;
            }
        }
        sc.close();
    }
}

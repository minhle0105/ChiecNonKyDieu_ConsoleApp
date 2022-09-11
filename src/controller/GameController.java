package controller;

import model.Game;
import model.Player;

public class GameController {
    Player player1;
    Player player2;
    String keyWord;

    Game game;

    public GameController(Player player1, Player player2, String keyWord) {
        this.player1 = player1;
        this.player2 = player2;
        this.keyWord = keyWord;
        this.game = new Game(this.player1, this.player2, this.keyWord.toCharArray());
    }

    public int play(char guess) {
        game.guess(guess);
        if (game.getWinnerId() != -1) {
            return game.getWinnerId();
        }
        game.displayTurn();
        return -1;
    }
}

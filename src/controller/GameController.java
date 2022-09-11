package controller;

import model.Game;
import model.Player;

public class GameController {
    Game game;

    public GameController(Player player1, Player player2, String keyWord) {
        this.game = new Game(player1, player2, keyWord.toCharArray());
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

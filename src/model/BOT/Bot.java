package model.BOT;

import model.Player.Player;
import model.Player.PlayerType;
import model.Player.Symbol;

public class Bot extends Player {

    private BotDifficulty botDifficulty;

    public Bot(String name, Integer id, Symbol symbol, PlayerType playerType, BotDifficulty botDifficulty) {
        super(name, id, symbol, playerType);
        this.botDifficulty  = botDifficulty.EASY;
    }
}

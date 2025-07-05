package model.BOT;

import model.Board.Board;
import model.Player.Moves;
import model.Player.Player;
import model.Player.PlayerType;
import model.Player.Symbol;

public class Bot extends Player {

    private BotDifficulty botDifficulty;

    public Bot(String name, Integer id, Symbol symbol, PlayerType playerType, BotDifficulty botDifficulty) {
        super(name, id, symbol, playerType);
        this.botDifficulty  = botDifficulty;
    }

    @Override
    public Moves makeMove(Board board){
        return BotDifficultyFactory.BotStratergyType(BotDifficulty.EASY).makeMove(board, this);
    }




}

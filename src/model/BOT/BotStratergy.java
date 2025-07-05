package model.BOT;

import model.Board.Board;
import model.Player.Moves;

public interface BotStratergy {

    Moves makeMove(Board board, Bot bot);

}

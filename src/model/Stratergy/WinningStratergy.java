package model.Stratergy;

import model.Board.Board;
import model.Player.Moves;


public interface WinningStratergy {

    void updateCounter(Moves playerMoves);

    boolean CheckWinner(Board board, Moves lastMove);
}

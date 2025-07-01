package model.Stratergy;

import model.Board.Board;
import model.Player.Moves;


public interface WinningStratergy {

    public boolean CheckWinner(Board board, Moves lastMove );
    void updateCounter(Moves playerMoves);
}

package model.BOT;

import model.Board.Board;
import model.Cell.Cell;
import model.Cell.CellState;
import model.Player.Moves;

public class EasyMove implements BotStratergy {

    @Override
    public Moves makeMove(Board board, Bot bot) {

        System.out.println("Bot is making move now....");

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Cell cell = board.getCell(i, j);
                if (cell.getState() == CellState.Empty) {
                    board.getCell(i,j).update(bot);
                    return new Moves(i, j, bot);
                }

            }
        }
        return null;

    }
}

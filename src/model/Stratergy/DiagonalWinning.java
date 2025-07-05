package model.Strategy;

import model.Board.Board;
import model.Player.Moves;
import model.Stratergy.WinningStratergy;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinning implements WinningStratergy {

    // 1 → main diagonal, 2 → anti-diagonal
    private HashMap<Integer, HashMap<String, Integer>> currentStatusOfDiagonal = new HashMap<>();

    @Override
    public void updateCounter(Moves playerMoves, Board board) {
        int row = playerMoves.getRow();
        int col = playerMoves.getCol();
        String playerName = playerMoves.getPlayer().getName();

        // Main diagonal condition
        if (row == col) {
            currentStatusOfDiagonal.putIfAbsent(1, new HashMap<>());
            HashMap<String, Integer> map = currentStatusOfDiagonal.get(1);
            map.put(playerName, map.getOrDefault(playerName, 0) + 1);
        }

        // Anti-diagonal condition
        if (row + col == board.getSize() - 1) {
            currentStatusOfDiagonal.putIfAbsent(2, new HashMap<>());
            HashMap<String, Integer> map = currentStatusOfDiagonal.get(2);
            map.put(playerName, map.getOrDefault(playerName, 0) + 1);
        }
    }

    @Override
    public boolean CheckWinner(Board board, Moves lastMove) {
        String player = lastMove.getPlayer().getName();
        int boardSize = board.getSize();
        int row = lastMove.getRow();
        int col = lastMove.getCol();

        // Check main diagonal
        if (row == col) {
            Map<String, Integer> map = currentStatusOfDiagonal.getOrDefault(1, new HashMap<>());
            if (map.getOrDefault(player, 0) == boardSize) return true;
        }

        // Check anti-diagonal
        if (row + col == boardSize - 1) {
            Map<String, Integer> map = currentStatusOfDiagonal.getOrDefault(2, new HashMap<>());
            if (map.getOrDefault(player, 0) == boardSize) return true;
        }

        return false;
    }
}

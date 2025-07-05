package model.Stratergy;

import model.Board.Board;
import model.Player.Moves;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinnig implements WinningStratergy{

    HashMap<Integer, HashMap<String,Integer>> currentStatusOfCol = new HashMap<Integer, HashMap<String,Integer>>();


    @Override
    public boolean CheckWinner(Board board, Moves lastMove) {
            int currentCol = lastMove.getCol();
            String player = lastMove.getPlayer().getName();
            if (currentStatusOfCol.containsKey(currentCol)) {
                Map<String, Integer> hm = currentStatusOfCol.get(currentCol);
                int count = hm.getOrDefault(player, 0);
                return count == board.getSize();
            }
            return false;
    }

    @Override
    public void updateCounter(Moves move, Board board) {

        Integer currentCol = move.getCol();
        String currentPlayer  = move.getPlayer().getName();

        // Initialize playerMap if row doesn't exist
        currentStatusOfCol.putIfAbsent(currentCol, new HashMap<>());
        HashMap<String, Integer> playerMap = currentStatusOfCol.get(currentCol);
        String playerName = move.getPlayer().getName();
        playerMap.put(playerName, playerMap.getOrDefault(playerName, 0) + 1);

    }
}

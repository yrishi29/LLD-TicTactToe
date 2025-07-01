package model.Stratergy;

import model.Board.Board;
import model.Player.Moves;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinnig implements WinningStratergy{

    HashMap<Integer, HashMap<String,Integer>> currentStatusOfColoumn = new HashMap<Integer, HashMap<String,Integer>>();


    @Override
    public boolean CheckWinner(Board board, Moves lastMove) {
            int currentCol = lastMove.getCol();
            String player = lastMove.getPlayer().getName();
            if (currentStatusOfColoumn.containsKey(currentCol)) {
                Map<String, Integer> hm = currentStatusOfColoumn.get(currentCol);
                int count = hm.getOrDefault(player, 0);
                return count == board.getSize();
            }
            return false;
    }


    public void updateCounter(Moves move) {

        Integer currentRow = move.getRow();
        String currentPlayer  = move.getPlayer().getName();

        // Initialize playerMap if row doesn't exist
        currentStatusOfColoumn.putIfAbsent(currentRow, new HashMap<>());
        HashMap<String, Integer> playerMap = currentStatusOfColoumn.get(currentRow);
        String playerName = move.getPlayer().getName();
        playerMap.put(playerName, playerMap.getOrDefault(playerName, 0) + 1);

    }
}

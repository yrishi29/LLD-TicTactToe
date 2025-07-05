package model.Stratergy;

import model.Board.Board;
import model.Player.Moves;

import java.util.HashMap;
import java.util.Map;

public class RowWinning implements WinningStratergy{

    private HashMap<Integer, HashMap<String,Integer>> currentStatusofRow = new HashMap<>();

    @Override
    public boolean CheckWinner(Board board, Moves lastMove) {

        int currentRow = lastMove.getRow();
        String player = lastMove.getPlayer().getName();
        if (currentStatusofRow.containsKey(currentRow)) {
            Map<String, Integer> hm = currentStatusofRow.get(currentRow);
            int count = hm.getOrDefault(player, 0);
            return count == board.getSize();
        }
        return false;
    }

    @Override
    public void updateCounter(Moves move, Board board){
        Integer currentRow = move.getRow();
        // Initialize playerMap if row doesn't exist
        currentStatusofRow.putIfAbsent(currentRow, new HashMap<>());
        HashMap<String, Integer> playerMap = currentStatusofRow.get(currentRow);
        String playerName = move.getPlayer().getName();
        playerMap.put(playerName, playerMap.getOrDefault(playerName, 0) + 1);

    }
}

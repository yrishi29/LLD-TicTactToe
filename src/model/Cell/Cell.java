package model.Cell;

import model.Player.Player;

public class Cell {

    private Integer row;
    private Player player;
    private Integer col;
    private CellState state;

    public void update(Player player){
        this.state = CellState.Occupied;
        this.player = player;

    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }

    public CellState getState() {
        return state;
    }

    public Player getPlayer() {
        return player;
    }


    public void setRow(Integer row) {
        this.row = row;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }



    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
        this.state = CellState.Empty;

    }
}

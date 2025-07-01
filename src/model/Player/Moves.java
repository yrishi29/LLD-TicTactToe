package model.Player;

public class Moves {

    private Integer row;
    private Integer col;
    private Player player;

    public Moves(Integer row, Integer col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }


    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }


}

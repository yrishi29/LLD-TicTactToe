package model.Player;

import model.Board.Board;
import model.Cell.Cell;

import java.util.Scanner;

public class Player {

    private Integer id;

    public Player(String name, Integer id, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType.HUMAN;
    }

    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Moves makeMove(Board board){
        System.out.println("Make Move----" + this.getName());
        System.out.println("choose row");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        System.out.println("choose Col");
        Scanner scanner2 = new Scanner(System.in);
        int col = scanner2.nextInt();

        Cell cell = new Cell(row, col);
        board.getCell(row,col).update(this);

        Moves move = new Moves(row, col, this);
        return move;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }


}

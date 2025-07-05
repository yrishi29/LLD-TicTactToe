package model.Player;

import model.Board.Board;
import model.Cell.Cell;
import model.Cell.CellState;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {

    private Integer id;

    public Player(String name, Integer id, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Moves makeMove(Board board){

        List<Integer> inputList = UserInput(board);
        int row = inputList.get(0);
        int col = inputList.get(1);
        while(checkValidMove(board,row,col)) {
            System.out.println("Not a valid move, already occupied");
            UserInput(board);
        }

        Cell cell = new Cell(row,col);
        board.getCell(row,col).update(this);
        Moves move = new Moves(row, col, this);
        return move;
    }

    public List<Integer> UserInput(Board board){
        System.out.println("Make Move----" + this.getName());
        System.out.println("choose row");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();

        while(row<0 || row>board.getSize()){
            System.out.println("Inavalid row");
            System.out.println("Enter again");
            row = scanner.nextInt();
        }

        System.out.println("choose Col");
        Scanner scanner2 = new Scanner(System.in);
        int col = scanner2.nextInt();

        while(col>board.getSize() || col<0){
            System.out.println("Inavalid col");
            System.out.println("Enter again");
            col = scanner.nextInt();
        }
        return Arrays.asList(row, col);
    }

    public boolean checkValidMove(Board board, int row, int col){
        if(board.getCell(row,col).getState() != CellState.Empty) return true;
        return false;
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

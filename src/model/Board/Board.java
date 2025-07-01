package model.Board;

import model.Cell.Cell;
import model.Cell.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {



    private Integer size;
    private List<List<Cell>> boards;

    public Board(Integer size) {
        this.size = size;
        createBoard(size);
    }

    public Cell getCell(int row, int col){
        return boards.get(row).get(col);
    }

    private void createBoard(Integer size) {
        this.boards = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }

            this.boards.add(row);
        }
    }

    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = boards.get(i).get(j);
                Character symbol;

                if (cell.getState() == CellState.Empty) {
                    symbol = ' ';
                } else {
                    symbol = cell.getPlayer().getSymbol().getSymbol();
                }

                System.out.print(" " + symbol + " ");
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();

            if (i < size - 1) {
                System.out.println("---".repeat(size) + "-".repeat(size - 1));
            }
        }
    }



    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<List<Cell>> getBoards() {
        return boards;
    }

    public void setBoards(List<List<Cell>> boards) {
        this.boards = boards;
    }



}

package model.Game;
import model.Board.Board;
import model.Player.Moves;
import model.Player.Player;
import model.Stratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private GameStatus gameStatus;
    private List<Moves> moves;
    private Integer currentPlayerIndex;
    private Player winner;
    private List<WinningStratergy> winningStrategies;

    // Constructor
    public Game(Builder builder) {
        this.players = builder.players;
        this.winningStrategies = builder.winningStrategies;
        this.board = new Board(builder.boardSize);
        this.moves = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.gameStatus = GameStatus.NotStarted;
    }

    // Static method to return Builder object
    public static Builder getBuilder() {
        return new Builder();
    }

    private void displayBoard(){
        this.board.displayBoard();
    }


    public void play() {
        displayBoard();
        gameStatus = GameStatus.Started;
        int moveCount = 0;

        while (gameStatus == GameStatus.Started || gameStatus == GameStatus.Draw) {

            Player currentPlayer = players.get(currentPlayerIndex);

            Moves playerMoves = currentPlayer.makeMove(board);
            ++moveCount;

            for (WinningStratergy winningStratergy : winningStrategies) {
                winningStratergy.updateCounter(playerMoves,board);
            }

            // Step 2: Check if any strategy declares a winner
            if (checkWinning(playerMoves, board)) {
                gameStatus = GameStatus.Completed;
                winner = currentPlayer;
                break;
            }

            if (moveCount == board.getSize() * board.getSize()) {
                gameStatus = GameStatus.Draw;
                System.out.println("It's a draw!");
                break;
            }

            displayBoard();

            // Step 3: Move to next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        if (gameStatus == GameStatus.Draw) {
            System.out.println("Draw");
        }
        if (gameStatus == GameStatus.Completed) {
            System.out.println("Winner is " + winner.getName());
        }

        displayBoard();
    }



    private boolean checkWinning(Moves moves, Board board){
        for(WinningStratergy winningStratergy: winningStrategies){
            if(winningStratergy.CheckWinner(board,moves)){
                return true;
            }
        }
        return false;
    }



    public static class Builder {
        private Integer boardSize;
        private List<Player> players;
        private List<WinningStratergy> winningStrategies;

        public Builder setboardSize(Integer boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder setplayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setwinningStrategies(List<WinningStratergy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build() {
            if (boardSize == null || boardSize <= 0) {
                throw new IllegalArgumentException("Board size must be greater than 0");
            }
            if (players == null || players.size() > boardSize - 1) {
                throw new IllegalArgumentException("Number of players must be <= boardSize - 1");
            }
            if (winningStrategies == null || winningStrategies.isEmpty()) {
                throw new IllegalArgumentException("At least one winning strategy must be provided");
            }

            return new Game(this);
        }
    }




}

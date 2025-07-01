import model.Game.Game;
import model.Player.Player;
import model.Player.PlayerType;
import model.Player.Symbol;
import model.Stratergy.ColumnWinnig;
import model.Stratergy.RowWinning;
import model.Stratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int size = 3;

        List<Player> players = new ArrayList<>(2);
        players.add(new Player("rishikesh",1, new Symbol('X'), PlayerType.HUMAN));
        players.add(new Player("viresh",2, new Symbol('O'), PlayerType.HUMAN));

        List<WinningStratergy> winningStratergies = new ArrayList<>(2);
        winningStratergies.add(new RowWinning());
        winningStratergies.add(new ColumnWinnig());

        //Game game = new Game(3,players, winningStratergies);

        Game game =  Game.getBuilder().
                setplayers(players).
                setwinningStrategies(winningStratergies).
                setboardSize(size).
                build();

        game.play();

    }
}
import model.BOT.Bot;
import model.BOT.BotDifficulty;
import model.Game.Game;
import model.Player.Player;
import model.Player.PlayerType;
import model.Player.Symbol;
import model.Strategy.DiagonalWinning;
import model.Stratergy.ColumnWinnig;
import model.Stratergy.RowWinning;
import model.Stratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int size = 5;

        List<Player> players = new ArrayList<>(2);
        players.add(new Player("rishikesh",1, new Symbol('X'), PlayerType.HUMAN));
        players.add(new Bot("bot",2,new Symbol('O'), PlayerType.BOT, BotDifficulty.EASY));

        List<WinningStratergy> winningStratergies = new ArrayList<>(2);
        winningStratergies.add(new RowWinning());
        winningStratergies.add(new ColumnWinnig());
        winningStratergies.add(new DiagonalWinning());

        Game game =  Game.getBuilder().
                setplayers(players).
                setwinningStrategies(winningStratergies).
                setboardSize(size).
                build();

        game.play();

    }
}
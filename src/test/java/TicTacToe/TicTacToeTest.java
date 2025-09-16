package TicTacToe;

import TicTacToe.Exceptions.InvalidPlayersException;
import TicTacToe.Models.*;
import TicTacToe.Strategies.Playing.RandomPlayingStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TicTacToeTest
{
    private static final int BOARD_SIZE = 3; //Screaming case
    @Test
    public void testCreateGame() throws InvalidPlayersException {
        /*Board board = new Board(BOARD_SIZE); // Magic numbers == hard coded
         Game game = new Game(board,  GameStatus.IN_PROGRESS);

        Game.Builder gameBuilder = new Game.Builder();
         */
       /* We can make the implementation better by using Builder method for Players as well
        Game game = Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(new HumanPlayer(GameSymbol.O, new User()))
                .withPlayer(new BotPlayer(GameSymbol.O, GameLevel.EASY, new RandomPlayingStrategy()))
                .build();

        */

        Game game = Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(HumanPlayer.builder().symbol(GameSymbol.X).user(new User("Sneha", "t", null)).build())
                .withPlayer(BotPlayer.builder().symbol(GameSymbol.O).level(GameLevel.EASY).playingStrategy(new RandomPlayingStrategy()).build())
                .build();


        assertEquals(2, game.getPlayers().size(), "If the game is created, it should have two players");


    }

    @Test
    public void testCreateBoard()
    {
        Board board = new Board(3);

        assertEquals(3, board.getCells().get(0).size(),
                "If the constructor of board is called with n, it should create n columns");

        List<BoardCell> firstRow = board.getCells().get(0);

        int rowSize = board.getCells().size();

        assertEquals(3, rowSize,
                "If the constructor of board is called with n, it should create n rows");
    }
}

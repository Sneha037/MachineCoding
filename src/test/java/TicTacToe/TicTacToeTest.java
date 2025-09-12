package TicTacToe;

import TicTacToe.Models.Board;
import TicTacToe.Models.BoardCell;
import TicTacToe.Models.Game;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TicTacToeTest
{
    @Test
    public void testCreateGame()
    {

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

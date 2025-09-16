package TicTacToe.Strategies.Playing;

import TicTacToe.Models.Board;
import TicTacToe.Models.BoardCell;
import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy
{
    @Override
    public BoardCell makeMove(Board board)
    {
        // Output --> a cell from the list of available cells
        //Get a list of empty cells

        List<BoardCell> availableCells = board.getAvailableCells();

        int randomIndex = (int)(Math.random() * availableCells.size());

        System.out.println("Available Cells: " + availableCells.size() + "Random Index" + randomIndex);

        //Generate a random x,y co-ordinate for the cells

        //Return the random cell

        BoardCell cell = availableCells.get(randomIndex);
        return new BoardCell(cell.getX(), cell.getY());
    }
}

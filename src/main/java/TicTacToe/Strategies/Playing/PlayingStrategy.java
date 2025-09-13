package TicTacToe.Strategies.Playing;

import TicTacToe.Models.Board;
import TicTacToe.Models.BoardCell;

public interface PlayingStrategy
{
    BoardCell makeMove(Board board);
}

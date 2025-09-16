package TicTacToe.Strategies.Winning;

import TicTacToe.Models.Board;
import TicTacToe.Models.GameSymbol;

public interface WinningStrategy
{
      boolean checkWinner(Board board, GameSymbol symbol);
}

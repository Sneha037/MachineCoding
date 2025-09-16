package TicTacToe.Strategies.Winning;

import TicTacToe.Models.Board;
import TicTacToe.Models.BoardCell;
import TicTacToe.Models.GameSymbol;

import java.util.List;

public class DiagonalWinningStrategy implements WinningStrategy
{
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol)
    {
        int n = board.getSize();

        List<List<BoardCell>>  boardCells = board.getCells();

        boolean winner = true;

        for(int i = 0; i < n; i++)
        {
             if(boardCells.get(i).get(i).getSymbol() != symbol)
             {
                 winner = false;
                 break;
             }

        }

        if(winner)
            return true;

        winner = true;

        for(int i = 0; i < n; i++)
        {
            if(boardCells.get(i).get(n-i-1).getSymbol() != symbol)
            {
                winner = false;
                break;
            }
        }

        if(winner)
            return true;

        return false;

    }
}

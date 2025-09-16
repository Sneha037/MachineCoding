package TicTacToe.Strategies.Winning;

import TicTacToe.Models.Board;
import TicTacToe.Models.BoardCell;
import TicTacToe.Models.GameSymbol;

import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy
{
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol)
    {
        int n = board.getSize();

        List<List<BoardCell>> list = board.getCells();

        for(int j=0; j<n; j++)
        {
            boolean winner = true;
            for(int i=0; i<n; i++)
            {
                if(list.get(i).get(j).getSymbol() != symbol)
                {
                    winner = false;
                    break;
                }
            }

            if(winner)
                return true;
        }

        return false;

    }
}

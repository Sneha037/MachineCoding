package TicTacToe.Strategies.Winning;

import TicTacToe.Models.Board;
import TicTacToe.Models.BoardCell;
import TicTacToe.Models.GameSymbol;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
public class RowWinningStrategy implements WinningStrategy
{
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol)
    {
        for(List<BoardCell> rows : board.getCells())
        {
            boolean isWinner = true;
            for(BoardCell cell : rows)
            {
                if(cell.getSymbol() != symbol)
                {
                    isWinner = false;
                    break;
                }
            }

            if(isWinner)
                return true;
        }
        return false;
    }
}

package TicTacToe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardCell
{
    private int x;
    private int y;
    private GameSymbol symbol;
}

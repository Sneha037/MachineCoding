package TicTacToe.Models;

import lombok.*;


@NoArgsConstructor
@Getter
//@Setter -- We don't want to use Setter methods as they mutate our objects instead we use the Builder annotation
@Builder(toBuilder = true)
// @Accessors - This annotation helps us in using fluent setters
@AllArgsConstructor
@Setter
public class BoardCell
{
    private int x;
    private int y;
    private GameSymbol symbol;

    public BoardCell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

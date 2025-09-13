package TicTacToe.Models;

//import TicTacToe.Models.Player;
//Extrinsic State

import lombok.Builder;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class HumanPlayer extends Player
{
    private User user;

    public HumanPlayer(GameSymbol symbol, User user)
    {
        super(symbol);
        this.user = user;
    }

    public BoardCell makeMove(Board board)
    {
        return null;
    }


}

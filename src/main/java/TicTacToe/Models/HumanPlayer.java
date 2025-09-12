package TicTacToe.Models;

//import TicTacToe.Models.Player;
//Extrinsic State

public class HumanPlayer extends Player
{
    private User user;

    public HumanPlayer(GameSymbol symbol, User user)
    {
        super(symbol);
        this.user = user;
    }
}

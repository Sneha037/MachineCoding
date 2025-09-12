package TicTacToe.Models;

//import TicTacToe.Models.Player;

public class BotPlayer extends Player
{
    private GameLevel level;

    public BotPlayer(GameSymbol symbol, GameLevel level)
    {
        super(symbol);
        this.level = level;
    }
}

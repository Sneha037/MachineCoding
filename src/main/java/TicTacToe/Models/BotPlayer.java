package TicTacToe.Models;

//import TicTacToe.Models.Player;

import TicTacToe.Strategies.Playing.PlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class BotPlayer extends Player
{
    private GameLevel level;

    private PlayingStrategy playingStrategy;

    public BotPlayer(GameSymbol symbol, GameLevel level, PlayingStrategy playingStrategy)
    {
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }

    public BoardCell makeMove(Board board)
    {
        BoardCell cell = playingStrategy.makeMove(board);
        cell.setSymbol(getSymbol());

        return cell;
    }
}

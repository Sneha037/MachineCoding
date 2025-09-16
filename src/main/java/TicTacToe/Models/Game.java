package TicTacToe.Models;

import TicTacToe.Exceptions.InvalidMoveException;
import TicTacToe.Exceptions.InvalidPlayersException;
import TicTacToe.Strategies.Winning.ColumnWinningStrategy;
import TicTacToe.Strategies.Winning.DiagonalWinningStrategy;
import TicTacToe.Strategies.Winning.RowWinningStrategy;
import TicTacToe.Strategies.Winning.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
//@AllArgsConstructor
public class Game
{
    private static final int NO_OF_PLAYERS = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private Board board;

    // Whenever we create a field which is a List, we make sure that we initialise that list
    //Why do we initialise List? To avoid null pointer exceptions
    private List<Player> players = new ArrayList<Player>();

    private GameStatus status;

    private int nextPlayerIndex = 0;

    private Player winner;

    private List<WinningStrategy> strategy = List.of(new RowWinningStrategy(), new ColumnWinningStrategy(), new DiagonalWinningStrategy());

    private Game()
    {
        //private constructor
    }

    public void makeMove() throws InvalidPlayersException {
        // 1. Get the next player
        // 2. Get the move from the player
        BoardCell move = getNextMove();
        // 3. Call makeMove(). The move for both the players will be different
        // 4. Bot will make a move through strategy - PlayingStrategy
        // 5. User - take input - Scanner

        // 6. Validate move - check if the cell was already filled or not
        // 7. Update the board
        board.updateBoard(move);
        // 8. Check for a winner

        if(checkWinner(move.getSymbol()))
        {
            status = GameStatus.FINISHED;
            winner = getNextPlayer();
            return;
        }
        // 9. Check for a draw

        if(checkDraw())
        {
            status = GameStatus.DRAW;
            return;
        }
        // This very well looks like a monster method

        //Update the next player
        nextPlayerIndex = (nextPlayerIndex + 1)%NO_OF_PLAYERS;


    }

    private BoardCell getNextMove()
    {
        Player player = players.get(nextPlayerIndex);
        BoardCell move = player.makeMove(board);
        validateMove(move);
        return move;
    }

    private void validateMove(BoardCell move)
    {
        boolean isEmpty = board.isEmpty(move.getX(), move.getY());

        if(!isEmpty)
            throw new InvalidMoveException("This is an invalid move, my child!");
    }

    public void startGame()
    {
        // Assign a random value to the nextPlayerIndex
        //Set the status to IN_PROGRESS;
        nextPlayerIndex = 0; //(int)(Math.random() * players.size());

        status = GameStatus.IN_PROGRESS;
    }

    public Player getNextPlayer() throws InvalidPlayersException
    {
        return players.get(nextPlayerIndex);
    }

    private boolean checkWinner(GameSymbol symbol)
    {
        //Implement check rows
        //return strategy.checkWinner(board, symbol);

        for(WinningStrategy strategy : strategy)
        {
            if(strategy.checkWinner(board, symbol) == true)
                return  true;
        }

        return false;
    }


    private boolean checkDraw()
    {
        return false;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    @Getter
    public static class Builder
    {
        //Friend class - static inner class
        private Game game;

        public Builder()
        {
            game = new Game();
        }

        public Builder withSize(int size)
        {
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player)
        {
            game.getPlayers().add(player);
            return this;
        }

        public Game build() throws InvalidPlayersException {
            boolean isValid = validate();
            if(!isValid)
                throw new InvalidPlayersException("Invalid List of Players");

            Game newGame = new Game();
            newGame.board = game.board;
            newGame.players = game.players;
            newGame.status = DEFAULT_STATUS;

            return newGame;
        }

        private boolean validate()
        {
            List<Player> players = game.getPlayers();
            if(players.size() != NO_OF_PLAYERS)
                return false;

            // If symbols are unique

           /* Set<GameSymbol> symbols = game.players.stream().map(
                    player -> player.getSymbol();
            ).collect(Collectors.toSet())
            */

            // Using stream to create a set of symbols
            Set<GameSymbol> symbols = players.stream().map(
                    Player::getSymbol
            ).collect(Collectors.toSet());

            return symbols.size() == NO_OF_PLAYERS;
        }
    }


}

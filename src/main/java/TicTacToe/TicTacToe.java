package TicTacToe;


import TicTacToe.Exceptions.InvalidPlayersException;
import TicTacToe.Models.*;
import TicTacToe.Strategies.Playing.RandomPlayingStrategy;

import java.util.Scanner;

//Client code
public class TicTacToe
{
    private static final int BOARD_SIZE = 3;

    public static void main(String[] args) throws InvalidPlayersException
    {
        System.out.println("Welcome to TicTacToe!");
        //Ask for user input - name, email, symbol
        HumanPlayer human = getUserInput();

        //Create a game
        Game game = createGame(human);
        //Initialise a bot player
        game.startGame();

        //Assume we are playing human vs bot

        //Start game
        //Assign the first player
        //Mark the game in progress

        //Make move - Start playing

        // We have to call makeMove() iteratively till a game is WON or DRAWN

        while(game.getStatus() == GameStatus.IN_PROGRESS)
        {
            Player player = game.getNextPlayer();

            System.out.println("Next Player's Symbol: " + player.getSymbol());

            game.makeMove();
            game.getBoard().printBoard();
        }

        if(game.getStatus() == GameStatus.FINISHED)
        {
            System.out.println("Thanks for playing! Winner is " + game.getWinner().getSymbol());
        }
        else
        {
            System.out.println("Thanks for playing! It's a tie!");
        }

    }

    public static HumanPlayer getUserInput()
    {
        //Scanner helps us take input from the command line
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");

        String name = scanner.nextLine();
        System.out.println("Enter your email: ");

        String email = scanner.nextLine();

        System.out.println("Enter your symbol: O or X");

        GameSymbol symbol;

        try
        {
            symbol = GameSymbol.valueOf(scanner.nextLine());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid symbol. Please enter a valid symbol: 0 or X");
            return null;
        }

        User user = new User(name, email, null);

        HumanPlayer humanPlayer = new HumanPlayer(symbol, user);

        return humanPlayer;

    }

    public static Game createGame(HumanPlayer humanPlayer) throws InvalidPlayersException
    {
        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(decideBotSymbol(humanPlayer.getSymbol()))
                                .level(GameLevel.EASY)
                                .playingStrategy(new RandomPlayingStrategy()).build()
                ).build();
    }

    public static GameSymbol decideBotSymbol(GameSymbol gameSymbol)
    {
        if (gameSymbol == GameSymbol.X)
        {
            return GameSymbol.O;
        }

        return GameSymbol.X;
    }
}

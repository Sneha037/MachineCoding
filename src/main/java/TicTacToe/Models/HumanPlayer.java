package TicTacToe.Models;

//import TicTacToe.Models.Player;
//Extrinsic State

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

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
        System.out.println("Enter X and Y coordinate: ");
        Scanner scanner =  new Scanner(System.in);


        int x = scanner.nextInt();
        int y = scanner.nextInt();

        return new BoardCell(x, y, getSymbol());
    }


}

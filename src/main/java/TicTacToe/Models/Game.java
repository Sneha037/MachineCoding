package TicTacToe.Models;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@AllArgsConstructor
public class Game
{
    private Board board;

    // Whenever we create a field which is a List, we make sure that we initialise that list
    //Why do we initialise List? To avoid null pointer exceptions
    private List<Player> players = new ArrayList<Player>();

    private GameStatus status;

    public void makeMove()
    {

    }

    public void startGame()
    {

    }

    private Player checkWinner()
    {
        return null;
    }

    private boolean checkDraw()
    {
        return false;
    }
}

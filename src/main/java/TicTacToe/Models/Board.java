package TicTacToe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
public class Board
{
      private int size;

      private List<List<BoardCell>> cells = new ArrayList<>();

      public Board(int size)
      {
          this.size = size;
          this.cells = initialiseCells(size);
      }

    private List<List<BoardCell>> initialiseCells(int size)
    {
        /*
        We can use 2 for loops, but we won't instead we'll use Arrays.fill()
        for(int i = 0; i < size; i++)
        {
            List<BoardCell> cells = new ArrayList<>
        }*/

        List<BoardCell> firstRow = Collections.nCopies(size, new BoardCell());
        List<List<BoardCell>> cell = Collections.nCopies(size, firstRow);
        return cell;
    }


}

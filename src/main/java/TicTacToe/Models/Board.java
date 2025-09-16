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

        List<List<BoardCell>> grid = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<BoardCell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new BoardCell(i, j)); // each cell is unique
            }
            grid.add(row);
        }

        return grid;
    }


    public boolean isEmpty(int x, int y)
    {
        return cells.get(x).get(y).getSymbol() == null;
    }

    public void updateBoard(BoardCell move)
    {
        int x = move.getX();
        int y = move.getY();
        cells.get(x).get(y).setSymbol(move.getSymbol());
       // printBoard();
    }

    public void printBoard()
    {
        for (int i = 0; i < cells.size(); ++i)
        {
            for (int j = 0; j < cells.size(); ++j)
            {
                GameSymbol symbol = cells.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.println();
        }
    }

    public List<BoardCell> getAvailableCells()
    {
        //return cells.stream().flatMap(array -> array.stream())

        return cells.stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getSymbol() == null)
                .toList();
    }
}

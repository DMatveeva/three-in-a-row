package threeinarow.game;

import java.util.LinkedHashMap;

public class GameMatrix extends Matrix {

    private LinkedHashMap<Coordinate, Letter> cells;
    private int [][] adjacencyMatrix = new int [64] [64];



/*
*  | a   b   c   d   e   f   g   h |
  |-------------------------------|
1 | 00  01  02  03  04  05  06  07 |
2 | 08  09  10  11  12  13  14  15 |
3 | 16  17  18  19  20  21  22  23 |
4 | 24   E   A   A   E   A   E   C |
5 | 32   B   A   A   E   A   E   C |
6 | 40   B   B   A   E   A   E   C |
7 | 48   B   C   A   E   A   E   C |
8 | 56  57  58 59  60  61  62  63 |

* */

    public GameMatrix(LinkedHashMap<Coordinate, Letter> cells, int[][] adjacencyMatrix) {
        this.cells = cells;
    }

    @Override
    public boolean containsFigures() {
        return false;
    }

    @Override
    public Figures getFigures() {
        return null;
    }

    @Override
    public void fillEmptyCells() {

    }

    @Override
    public void swapCells(Coordinate from, Coordinate to) {

    }

    @Override
    public void cleanFigures(Figures figures) {

    }

    @Override
    public void clear() {

    }
}


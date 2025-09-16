package threeinarow.matrix.atd.impl.factory;

import threeinarow.matrix.atd.MatrixFactory;
import threeinarow.matrix.atd.impl.GameCells;
import threeinarow.matrix.atd.impl.GameMatrix;
import threeinarow.matrix.realization.AdjacencyMatrix;
import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.Coordinate;
import threeinarow.matrix.realization.Letter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class GameMatrixFactory extends MatrixFactory {

    private static final GameMatrixFactory INSTANCE = new GameMatrixFactory();

    public static GameMatrixFactory getInstance() {
        return INSTANCE;
    }


    private final static Random random = new Random();

    @Override
    public GameMatrix createMatrix() {
        GameCells gameCells = createMatrixCells();
        AdjacencyMatrix adjacencyMatrix = createAdjacencyMatrix();
        return new GameMatrix(gameCells, adjacencyMatrix);
    }

    private GameCells createMatrixCells() {
        LinkedHashMap<Coordinate, Cell> map = new LinkedHashMap<>();
        for(Coordinate c: Coordinate.values()) {
            Cell cell = new Cell(getRandomLetter());
            map.put(c, cell);
        }

        return new GameCells(map);
    }

    private static Letter getRandomLetter() {
        List<Letter> letters = Letter.getNotEmpty();
        int randomIndex = random.nextInt(letters.size());
        return letters.get(randomIndex);
    }

    private AdjacencyMatrix createAdjacencyMatrix() {
        return new AdjacencyMatrix(getAdjacencyMatrix());
    }

    private static int[][] getAdjacencyMatrix() {
        int size = Coordinate.getCount();
        int [][] adjacencyMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (areNeighbors(i, j)) {
                    adjacencyMatrix[i][j] = 1;
                }
            }
        }
        return adjacencyMatrix;
    }

    private static boolean areNeighbors(int a, int b) {
        int width = Coordinate.getMaxWidth();
        int ax = a % width;  //0 ...7
        int ay = a / width;  //0 ...7
        int bx = b % width;
        int by = b / width;
        return (ax == bx && Math.abs(ay - by) == 1) || (ay == by && Math.abs(ax - bx) == 1);
    }

}
/*
*
  | a   b   c   d   e   f   g   h |
1 | 00  01  02  03  04  05  06  07 |
2 | 08  09  10  11  12  13  14  15 |
3 | 16  17  18  19  20  21  22  23 |
4 | 24   E   A   A   E   A   E   C |
5 | 32   B   A   A   E   A   E   C |
6 | 40   B   B   A   E   A   E   C |
7 | 48   B   C   A   E   A   E   C |
8 | 56  57  58 59  60  61  62  63 |

* */


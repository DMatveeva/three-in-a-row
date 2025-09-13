package threeinarow.game.atd;

import threeinarow.game.realization.Coordinate;
import threeinarow.game.realization.Letter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Random;

public class MatrixFactory {

    public static final MatrixFactory INSTANCE = new MatrixFactory();

    static final int size = 64;
    static final int width = 8;
    private final static Random random = new Random();

    public static Matrix create() {
        int[][] adjacencyMatrix = getAdjacencyMatrix();
        LinkedHashMap<Coordinate, Letter> cells = new LinkedHashMap<>();
        return new GameMatrix(cells, adjacencyMatrix);
    }

    public static int[][] getAdjacencyMatrix() {
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
        int ax = a % width;  //0 ...7
        int ay = a / width;  //0 ...7
        int bx = b % width;
        int by = b / width;
        return (ax == bx && Math.abs(ay - by) == 1) || (ay == by && Math.abs(ax - bx) == 1);
    }

    public static LinkedHashMap<Coordinate, Letter> getCells() {
        LinkedHashMap<Coordinate, Letter> cells = new LinkedHashMap<Coordinate, Letter>();
        Arrays.stream(Coordinate.values()).forEach(coordinate -> cells.put(coordinate, getRandomLetter()));
        return cells;
    }

    private static Letter getRandomLetter() {
        int randomIndex = random.nextInt(5);
        return Letter.values()[randomIndex];
    }

}
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
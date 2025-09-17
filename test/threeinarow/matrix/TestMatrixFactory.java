package threeinarow.matrix;

import threeinarow.matrix.atd.impl.GameCells;
import threeinarow.matrix.realization.AdjacencyMatrix;
import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.CartesianCoordinate;

import java.util.LinkedHashMap;
import java.util.Random;

import static threeinarow.matrix.realization.Coordinate.*;
import static threeinarow.matrix.realization.Letter.*;

public class TestMatrixFactory {

    private final static Random random = new Random();

    public static GameCells createMatrixCells() {
        LinkedHashMap<CartesianCoordinate, Cell> map = new LinkedHashMap<>();

        map.put(new CartesianCoordinate(a, a), new Cell(A));
        map.put(new CartesianCoordinate(a, b), new Cell(A));
        map.put(new CartesianCoordinate(a, c), new Cell(B));
        map.put(new CartesianCoordinate(a, d), new Cell(A));
        map.put(new CartesianCoordinate(a, e), new Cell(C));
        map.put(new CartesianCoordinate(a, f), new Cell(D));
        map.put(new CartesianCoordinate(a, g), new Cell(E));
        map.put(new CartesianCoordinate(a, h), new Cell(A));

        map.put(new CartesianCoordinate(b, a), new Cell(B));
        map.put(new CartesianCoordinate(b, b), new Cell(A));
        map.put(new CartesianCoordinate(b, c), new Cell(C));
        map.put(new CartesianCoordinate(b, d), new Cell(C));
        map.put(new CartesianCoordinate(b, e), new Cell(A));
        map.put(new CartesianCoordinate(b, f), new Cell(C));
        map.put(new CartesianCoordinate(b, g), new Cell(A));
        map.put(new CartesianCoordinate(b, h), new Cell(A));

        map.put(new CartesianCoordinate(c, a), new Cell(D));
        map.put(new CartesianCoordinate(c, b), new Cell(A));
        map.put(new CartesianCoordinate(c, c), new Cell(D));
        map.put(new CartesianCoordinate(c, d), new Cell(E));
        map.put(new CartesianCoordinate(c, e), new Cell(A));
        map.put(new CartesianCoordinate(c, f), new Cell(E));
        map.put(new CartesianCoordinate(c, g), new Cell(A));
        map.put(new CartesianCoordinate(c, h), new Cell(C));

        map.put(new CartesianCoordinate(d, a), new Cell(C));
        map.put(new CartesianCoordinate(d, b), new Cell(C));
        map.put(new CartesianCoordinate(d, c), new Cell(B));
        map.put(new CartesianCoordinate(d, d), new Cell(A));
        map.put(new CartesianCoordinate(d, e), new Cell(B));
        map.put(new CartesianCoordinate(d, f), new Cell(A));
        map.put(new CartesianCoordinate(d, g), new Cell(B));
        map.put(new CartesianCoordinate(d, h), new Cell(C));

        map.put(new CartesianCoordinate(e, a), new Cell(C));
        map.put(new CartesianCoordinate(e, b), new Cell(C));
        map.put(new CartesianCoordinate(e, c), new Cell(A));
        map.put(new CartesianCoordinate(e, d), new Cell(D));
        map.put(new CartesianCoordinate(e, e), new Cell(D));
        map.put(new CartesianCoordinate(e, f), new Cell(A));
        map.put(new CartesianCoordinate(e, g), new Cell(C));
        map.put(new CartesianCoordinate(e, h), new Cell(A));

        map.put(new CartesianCoordinate(f, a), new Cell(C));
        map.put(new CartesianCoordinate(f, b), new Cell(A));
        map.put(new CartesianCoordinate(f, c), new Cell(C));
        map.put(new CartesianCoordinate(f, d), new Cell(C));
        map.put(new CartesianCoordinate(f, e), new Cell(E));
        map.put(new CartesianCoordinate(f, f), new Cell(E));
        map.put(new CartesianCoordinate(f, g), new Cell(C));
        map.put(new CartesianCoordinate(f, h), new Cell(A));

        map.put(new CartesianCoordinate(g, a), new Cell(E));
        map.put(new CartesianCoordinate(g, b), new Cell(B));
        map.put(new CartesianCoordinate(g, c), new Cell(B));
        map.put(new CartesianCoordinate(g, d), new Cell(A));
        map.put(new CartesianCoordinate(g, e), new Cell(C));
        map.put(new CartesianCoordinate(g, f), new Cell(A));
        map.put(new CartesianCoordinate(g, g), new Cell(C));
        map.put(new CartesianCoordinate(g, h), new Cell(A));

        map.put(new CartesianCoordinate(h, a), new Cell(D));
        map.put(new CartesianCoordinate(h, b), new Cell(D));
        map.put(new CartesianCoordinate(h, c), new Cell(B));
        map.put(new CartesianCoordinate(h, d), new Cell(C));
        map.put(new CartesianCoordinate(h, e), new Cell(B));
        map.put(new CartesianCoordinate(h, f), new Cell(D));
        map.put(new CartesianCoordinate(h, g), new Cell(C));
        map.put(new CartesianCoordinate(h, h), new Cell(A));

        return new GameCells(map);
    }

    public static AdjacencyMatrix createAdjacencyMatrix() {
        return new AdjacencyMatrix(getAdjacencyMatrix());
    }

    private static int[][] getAdjacencyMatrix() {
        int size = CartesianCoordinate.getCount();
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
        int width = CartesianCoordinate.getMaxWidth();
        int ax = a % width;  //0 ...7
        int ay = a / width;  //0 ...7
        int bx = b % width;
        int by = b / width;
        return (ax == bx && Math.abs(ay - by) == 1) || (ay == by && Math.abs(ax - bx) == 1);
    }

}

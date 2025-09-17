package threeinarow.matrix.atd;

import org.junit.jupiter.api.Test;
import threeinarow.matrix.TestMatrixFactory;
import threeinarow.matrix.atd.impl.GameCells;
import threeinarow.matrix.atd.impl.GameMatrix;
import threeinarow.matrix.realization.AdjacencyMatrix;
import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.Coordinate;

import static org.junit.jupiter.api.Assertions.*;
import static threeinarow.matrix.realization.Coordinate.*;
import static threeinarow.matrix.realization.Letter.*;

class MatrixTest {
    //GameMatrixFactory factory = GameMatrixFactory.getInstance();
    GameCells cells = TestMatrixFactory.createMatrixCells();
    AdjacencyMatrix adjacencyMatrix = TestMatrixFactory.createAdjacencyMatrix();

    Cell cA = new Cell(A);
    Cell cB = new Cell(B);
    Cell cC = new Cell(C);
    Cell cD = new Cell(D);
    Cell cE = new Cell(E);

    CartesianCoordinate a1 = new CartesianCoordinate(a, a);
    CartesianCoordinate a2 = new CartesianCoordinate(a, b);

    @Test
    void test_createMatrix() {
        Matrix matrix = new GameMatrix(cells, adjacencyMatrix);
        String view = matrix.getViewForUI();
        System.out.println(view);
    }
    @Test
    void test_swapCells() {
        Matrix matrix = new GameMatrix(cells, adjacencyMatrix);
        assertEquals(cells.getByCoordinate(a1), cA);
        assertEquals(cells.getByCoordinate(a2), cB);

        matrix.swapCells(a1, a2);

        assertEquals(cells.getByCoordinate(a1), cB);
        assertEquals(cells.getByCoordinate(a2), cA);
    }

}


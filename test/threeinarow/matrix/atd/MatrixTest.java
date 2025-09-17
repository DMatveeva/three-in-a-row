package threeinarow.matrix.atd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import threeinarow.matrix.TestMatrixFactory;
import threeinarow.matrix.atd.impl.GameCells;
import threeinarow.matrix.atd.impl.GameMatrix;
import threeinarow.matrix.realization.AdjacencyMatrix;
import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.Coordinate;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static threeinarow.matrix.realization.Coordinate.*;
import static threeinarow.matrix.realization.Letter.*;
//import static org.assertj.core.api.Assertions.assertThat;


class MatrixTest {
    //GameMatrixFactory factory = GameMatrixFactory.getInstance();
    static GameCells cells = TestMatrixFactory.createMatrixCells();
    AdjacencyMatrix adjacencyMatrix = TestMatrixFactory.createAdjacencyMatrix();

    static Cell cA = new Cell(A);
    static Cell cB = new Cell(B);
    static Cell cC = new Cell(C);
    static Cell cD = new Cell(D);
    static Cell cE = new Cell(E);

    static CartesianCoordinate a0 = new CartesianCoordinate(a, a);
    static CartesianCoordinate b0 = new CartesianCoordinate(b, a);
    static CartesianCoordinate a2 = new CartesianCoordinate(a, c);
    static CartesianCoordinate a3 = new CartesianCoordinate(a, d);

    @Test
    void test_createMatrix() {
        Matrix matrix = new GameMatrix(cells, adjacencyMatrix);
        String view = matrix.getViewForUI();
        System.out.println(view);
    }
    @ParameterizedTest
    @MethodSource("swapSource")
    void test_swapCells_ok(CartesianCoordinate from, CartesianCoordinate to, Cell fromValue, Cell toValue) {
        Matrix matrix = new GameMatrix(cells, adjacencyMatrix);
        assertEquals(fromValue, cells.getByCoordinate(from));
        assertEquals(toValue, cells.getByCoordinate(to));

        matrix.swapCells(from, to);

        assertEquals(matrix.getSwapCellStatus(), Matrix.SWAP_CELL_STATUS_OK);
        assertEquals(toValue, cells.getByCoordinate(from));
        assertEquals(fromValue, cells.getByCoordinate(to));
    }

    static Stream<Arguments> swapSource() {
        return Stream.of(
                Arguments.of(a0, b0, cA, cB),
                Arguments.of(a2, a3, cB, cA)
        );
    }

    @Test
    void test_swapCells_err() {
        Matrix matrix = new GameMatrix(cells, adjacencyMatrix);
        CartesianCoordinate from = new CartesianCoordinate(c, c);
        CartesianCoordinate to = new CartesianCoordinate(c, e);
        assertEquals(cD, cells.getByCoordinate(from));
        assertEquals(cA, cells.getByCoordinate(to));

        matrix.swapCells(from, to);

        assertEquals(matrix.getSwapCellStatus(), Matrix.SWAP_CELL_STATUS_ERR);
        assertEquals(cD, cells.getByCoordinate(from));
        assertEquals(cA, cells.getByCoordinate(to));

    }
}

/*
   | a  b  c  d  e  f  g  h |
---|------------------------|
a0 | B  A  D  C  C  C  E  D |
b1 | A  A  A  C  C  A  B  D |
c2 | A  C  D  B  A  C  B  B |
d3 | B  C  E  A  D  C  A  C |
e4 | C  A  A  B  D  E  C  B |
f5 | D  C  E  A  A  E  A  D |
g6 | E  A  A  B  C  C  C  C |
h7 | A  A  C  C  A  A  A  A |
--|------------------------|*/
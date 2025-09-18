package threeinarow.matrix.atd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import threeinarow.matrix.TestMatrixFactory;
import threeinarow.matrix.atd.impl.GameCells;
import threeinarow.matrix.atd.impl.GameMatrix;
import threeinarow.matrix.realization.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static threeinarow.matrix.Constants.*;
import static threeinarow.matrix.realization.Coordinate.*;
import static threeinarow.matrix.realization.Letter.*;
//import static org.assertj.core.api.Assertions.assertThat;


class MatrixTest {
    //GameMatrixFactory factory = GameMatrixFactory.getInstance();

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

    @Test
    void test_getFigures() {
        Matrix matrix = new GameMatrix(cells, adjacencyMatrix);

        HashMap<CartesianCoordinate, Cell> cells1 = new HashMap<>();
        cells1.put(d0, cC);
        cells1.put(e0, cC);
        cells1.put(f0, cC);
        Figure figure1 = new Figure(cells1);

        HashMap<CartesianCoordinate, Cell> cells2 = new HashMap<>();
        cells2.put(a1, cA);
        cells2.put(b1, cA);
        cells2.put(c1, cA);
        Figure figure2 = new Figure(cells2);

        HashMap<CartesianCoordinate, Cell> cells3 = new HashMap<>();
        cells3.put(e6, cC);
        cells3.put(f6, cC);
        cells3.put(g6, cC);
        cells3.put(h6, cC);
        Figure figure3 = new Figure(cells3);

        HashMap<CartesianCoordinate, Cell> cells4 = new HashMap<>();
        cells4.put(e7, cA);
        cells4.put(f7, cA);
        cells4.put(g7, cA);
        cells4.put(h7, cA);
        Figure figure4 = new Figure(cells4);

        Figures expected = new Figures(List.of(figure1, figure2, figure3, figure4));

        Figures figures = matrix.getFigures();
        assertEquals(expected, figures);

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
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
   static CartesianCoordinate a1 = new CartesianCoordinate(a, b);
   static CartesianCoordinate a2 = new CartesianCoordinate(a, c);
   static CartesianCoordinate a3 = new CartesianCoordinate(a, d);
   static CartesianCoordinate a4 = new CartesianCoordinate(a, e);
   static CartesianCoordinate a5 = new CartesianCoordinate(a, f);
   static CartesianCoordinate a6 = new CartesianCoordinate(a, g);
   static CartesianCoordinate a7 = new CartesianCoordinate(a, h);

    static CartesianCoordinate b0 = new CartesianCoordinate(b, a);
    static CartesianCoordinate b1 = new CartesianCoordinate(b, b);
    static CartesianCoordinate b2 = new CartesianCoordinate(b, c);
    static CartesianCoordinate b3 = new CartesianCoordinate(b, d);
    static CartesianCoordinate b4 = new CartesianCoordinate(b, e);
    static CartesianCoordinate b5 = new CartesianCoordinate(b, f);
    static CartesianCoordinate b6 = new CartesianCoordinate(b, g);
    static CartesianCoordinate b7 = new CartesianCoordinate(b, h);

    static CartesianCoordinate c0 = new CartesianCoordinate(c, a);
    static CartesianCoordinate c1 = new CartesianCoordinate(c, b);
    static CartesianCoordinate c2 = new CartesianCoordinate(c, c);
    static CartesianCoordinate c3 = new CartesianCoordinate(c, d);
    static CartesianCoordinate c4 = new CartesianCoordinate(c, e);
    static CartesianCoordinate c5 = new CartesianCoordinate(c, f);
    static CartesianCoordinate c6 = new CartesianCoordinate(c, g);
    static CartesianCoordinate c7 = new CartesianCoordinate(c, h);

    static CartesianCoordinate d0 = new CartesianCoordinate(d, a);
    static CartesianCoordinate d1 = new CartesianCoordinate(d, b);
    static CartesianCoordinate d2 = new CartesianCoordinate(d, c);
    static CartesianCoordinate d3 = new CartesianCoordinate(d, d);
    static CartesianCoordinate d4 = new CartesianCoordinate(d, e);
    static CartesianCoordinate d5 = new CartesianCoordinate(d, f);
    static CartesianCoordinate d6 = new CartesianCoordinate(d, g);
    static CartesianCoordinate d7 = new CartesianCoordinate(d, h);

    static CartesianCoordinate e0 = new CartesianCoordinate(e, a);
    static CartesianCoordinate e1 = new CartesianCoordinate(e, b);
    static CartesianCoordinate e2 = new CartesianCoordinate(e, c);
    static CartesianCoordinate e3 = new CartesianCoordinate(e, d);
    static CartesianCoordinate e4 = new CartesianCoordinate(e, e);
    static CartesianCoordinate e5 = new CartesianCoordinate(e, f);
    static CartesianCoordinate e6 = new CartesianCoordinate(e, g);
    static CartesianCoordinate e7 = new CartesianCoordinate(e, h);

    static CartesianCoordinate f0 = new CartesianCoordinate(f, a);
    static CartesianCoordinate f1 = new CartesianCoordinate(f, b);
    static CartesianCoordinate f2 = new CartesianCoordinate(f, c);
    static CartesianCoordinate f3 = new CartesianCoordinate(f, d);
    static CartesianCoordinate f4 = new CartesianCoordinate(f, e);
    static CartesianCoordinate f5 = new CartesianCoordinate(f, f);
    static CartesianCoordinate f6 = new CartesianCoordinate(f, g);
    static CartesianCoordinate f7 = new CartesianCoordinate(f, h);

    static CartesianCoordinate g0 = new CartesianCoordinate(f, a);
    static CartesianCoordinate g1 = new CartesianCoordinate(f, b);
    static CartesianCoordinate g2 = new CartesianCoordinate(f, c);
    static CartesianCoordinate g3 = new CartesianCoordinate(f, d);
    static CartesianCoordinate g4 = new CartesianCoordinate(f, e);
    static CartesianCoordinate g5 = new CartesianCoordinate(f, f);
    static CartesianCoordinate g6 = new CartesianCoordinate(f, g);
    static CartesianCoordinate g7 = new CartesianCoordinate(f, h);

    static CartesianCoordinate h0 = new CartesianCoordinate(h, a);
    static CartesianCoordinate h1 = new CartesianCoordinate(h, b);
    static CartesianCoordinate h2 = new CartesianCoordinate(h, c);
    static CartesianCoordinate h3 = new CartesianCoordinate(h, d);
    static CartesianCoordinate h4 = new CartesianCoordinate(h, e);
    static CartesianCoordinate h5 = new CartesianCoordinate(h, f);
    static CartesianCoordinate h6 = new CartesianCoordinate(h, g);
    static CartesianCoordinate h7 = new CartesianCoordinate(h, h);

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
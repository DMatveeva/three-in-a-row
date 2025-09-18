package threeinarow.matrix;

import threeinarow.matrix.atd.impl.GameCells;
import threeinarow.matrix.realization.AdjacencyMatrix;
import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.Cell;
import static threeinarow.matrix.realization.Coordinate.a;
import static threeinarow.matrix.realization.Coordinate.*;
import static threeinarow.matrix.realization.Letter.*;

public class Constants {

    public static GameCells cells = TestMatrixFactory.createMatrixCells();
    public static AdjacencyMatrix adjacencyMatrix = TestMatrixFactory.createAdjacencyMatrix();

    public static Cell cA = new Cell(A);
    public static Cell cB = new Cell(B);
    public static Cell cC = new Cell(C);
    public static Cell cD = new Cell(D);
    public static Cell cE = new Cell(E);

    public static CartesianCoordinate a0 = new CartesianCoordinate(a, a);
    public static CartesianCoordinate a1 = new CartesianCoordinate(a, b);
    public static CartesianCoordinate a2 = new CartesianCoordinate(a, c);
    public static CartesianCoordinate a3 = new CartesianCoordinate(a, d);
    public static CartesianCoordinate a4 = new CartesianCoordinate(a, e);
    public static CartesianCoordinate a5 = new CartesianCoordinate(a, f);
    public static CartesianCoordinate a6 = new CartesianCoordinate(a, g);
    public static CartesianCoordinate a7 = new CartesianCoordinate(a, h);

    public static CartesianCoordinate b0 = new CartesianCoordinate(b, a);
    public static CartesianCoordinate b1 = new CartesianCoordinate(b, b);
    public static CartesianCoordinate b2 = new CartesianCoordinate(b, c);
    public static CartesianCoordinate b3 = new CartesianCoordinate(b, d);
    public static CartesianCoordinate b4 = new CartesianCoordinate(b, e);
    public static CartesianCoordinate b5 = new CartesianCoordinate(b, f);
    public static CartesianCoordinate b6 = new CartesianCoordinate(b, g);
    public static CartesianCoordinate b7 = new CartesianCoordinate(b, h);

    public static CartesianCoordinate c0 = new CartesianCoordinate(c, a);
    public static CartesianCoordinate c1 = new CartesianCoordinate(c, b);
    public static CartesianCoordinate c2 = new CartesianCoordinate(c, c);
    public static CartesianCoordinate c3 = new CartesianCoordinate(c, d);
    public static CartesianCoordinate c4 = new CartesianCoordinate(c, e);
    public static CartesianCoordinate c5 = new CartesianCoordinate(c, f);
    public static CartesianCoordinate c6 = new CartesianCoordinate(c, g);
    public static CartesianCoordinate c7 = new CartesianCoordinate(c, h);

    public static CartesianCoordinate d0 = new CartesianCoordinate(d, a);
    public static CartesianCoordinate d1 = new CartesianCoordinate(d, b);
    public static CartesianCoordinate d2 = new CartesianCoordinate(d, c);
    public static CartesianCoordinate d3 = new CartesianCoordinate(d, d);
    public static CartesianCoordinate d4 = new CartesianCoordinate(d, e);
    public static CartesianCoordinate d5 = new CartesianCoordinate(d, f);
    public static CartesianCoordinate d6 = new CartesianCoordinate(d, g);
    public static CartesianCoordinate d7 = new CartesianCoordinate(d, h);

    public static CartesianCoordinate e0 = new CartesianCoordinate(e, a);
    public static CartesianCoordinate e1 = new CartesianCoordinate(e, b);
    public static CartesianCoordinate e2 = new CartesianCoordinate(e, c);
    public static CartesianCoordinate e3 = new CartesianCoordinate(e, d);
    public static CartesianCoordinate e4 = new CartesianCoordinate(e, e);
    public static CartesianCoordinate e5 = new CartesianCoordinate(e, f);
    public static CartesianCoordinate e6 = new CartesianCoordinate(e, g);
    public static CartesianCoordinate e7 = new CartesianCoordinate(e, h);

    public static CartesianCoordinate f0 = new CartesianCoordinate(f, a);
    public static CartesianCoordinate f1 = new CartesianCoordinate(f, b);
    public static CartesianCoordinate f2 = new CartesianCoordinate(f, c);
    public static CartesianCoordinate f3 = new CartesianCoordinate(f, d);
    public static CartesianCoordinate f4 = new CartesianCoordinate(f, e);
    public static CartesianCoordinate f5 = new CartesianCoordinate(f, f);
    public static CartesianCoordinate f6 = new CartesianCoordinate(f, g);
    public static CartesianCoordinate f7 = new CartesianCoordinate(f, h);

    public static CartesianCoordinate g0 = new CartesianCoordinate(g, a);
    public static CartesianCoordinate g1 = new CartesianCoordinate(g, b);
    public static CartesianCoordinate g2 = new CartesianCoordinate(g, c);
    public static CartesianCoordinate g3 = new CartesianCoordinate(g, d);
    public static CartesianCoordinate g4 = new CartesianCoordinate(g, e);
    public static CartesianCoordinate g5 = new CartesianCoordinate(g, f);
    public static CartesianCoordinate g6 = new CartesianCoordinate(g, g);
    public static CartesianCoordinate g7 = new CartesianCoordinate(g, h);

    public static CartesianCoordinate h0 = new CartesianCoordinate(h, a);
    public static CartesianCoordinate h1 = new CartesianCoordinate(h, b);
    public static CartesianCoordinate h2 = new CartesianCoordinate(h, c);
    public static CartesianCoordinate h3 = new CartesianCoordinate(h, d);
    public static CartesianCoordinate h4 = new CartesianCoordinate(h, e);
    public static CartesianCoordinate h5 = new CartesianCoordinate(h, f);
    public static CartesianCoordinate h6 = new CartesianCoordinate(h, g);
    public static CartesianCoordinate h7 = new CartesianCoordinate(h, h);
}

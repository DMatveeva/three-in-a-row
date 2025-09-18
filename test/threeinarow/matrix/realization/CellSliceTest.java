package threeinarow.matrix.realization;

import org.junit.jupiter.api.Test;
import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.atd.impl.GameMatrix;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static threeinarow.matrix.Constants.*;
import static threeinarow.matrix.Constants.adjacencyMatrix;
import static threeinarow.matrix.realization.Coordinate.*;
import static threeinarow.matrix.realization.Letter.*;
import static threeinarow.matrix.realization.Letter.A;

class CellSliceTest {

    @Test
    void test_getRows() {
        List<CellSlice> row = cells.getRows();
        CellSlice actual = row.get(0);

        LinkedHashMap<CartesianCoordinate, Cell> map = new LinkedHashMap<>();
        map.put(new CartesianCoordinate(a, a), new Cell(A));
        map.put(new CartesianCoordinate(b, a), new Cell(B));
        map.put(new CartesianCoordinate(c, a), new Cell(D));
        map.put(new CartesianCoordinate(d, a), new Cell(C));
        map.put(new CartesianCoordinate(e, a), new Cell(C));
        map.put(new CartesianCoordinate(f, a), new Cell(C));
        map.put(new CartesianCoordinate(g, a), new Cell(E));
        map.put(new CartesianCoordinate(h, a), new Cell(D));
        map.put(new CartesianCoordinate(h, a), new Cell(E));
        CellSlice expected = new CellSlice(map);

        assertEquals(expected, actual);
    }

    @Test
    void test_getSequencedCells() {
        List<CellSlice> row = cells.getRows();
        CellSlice slice0 = row.get(0);

        Figure figure0 = new Figure();
        figure0.addCell(d0, cC);
        figure0.addCell(e0, cC);
        figure0.addCell(f0, cC);
        Figures figures0 = new Figures(List.of(figure0));
        assertEquals(figures0, slice0.getThreeInARowCells());

        CellSlice slice1 = row.get(1);
        Figure figure10 = new Figure();
        figure10.addCell(a1, cA);
        figure10.addCell(b1, cA);
        figure10.addCell(c1, cA);
        Figure figure11 = new Figure();
        figure11.addCell(f1, cD);
        figure11.addCell(g1, cD);
        figure11.addCell(h1, cD);
        Figures figures1 = new Figures(List.of(figure10, figure11));
        assertEquals(figures1, slice1.getThreeInARowCells());



    }

}
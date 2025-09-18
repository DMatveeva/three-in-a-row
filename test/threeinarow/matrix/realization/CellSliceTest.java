package threeinarow.matrix.realization;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static threeinarow.matrix.Constants.*;
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
        Figures figures0 = new Figures(Set.of(figure0));
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
        Figures figures1 = new Figures(Set.of(figure10, figure11));
        assertEquals(figures1, slice1.getThreeInARowCells());

        CellSlice slice2 = row.get(2);
        assertEquals(Figures.empty(), slice2.getThreeInARowCells());

        CellSlice slice3 = row.get(3);
        assertEquals(Figures.empty(), slice3.getThreeInARowCells());

        CellSlice slice4 = row.get(4);
        assertEquals(Figures.empty(), slice4.getThreeInARowCells());

        CellSlice slice5 = row.get(5);
        assertEquals(Figures.empty(), slice5.getThreeInARowCells());

        CellSlice slice6 = row.get(6);
        Figure figure6 = new Figure();
        figure6.addCell(e6, cC);
        figure6.addCell(f6, cC);
        figure6.addCell(g6, cC);
        figure6.addCell(h6, cC);
        Figures figures6 = new Figures(Set.of(figure6));
        assertEquals(figures6, slice6.getThreeInARowCells());

        CellSlice slice7 = row.get(7);
        Figure figure7 = new Figure();
        figure7.addCell(e7, cA);
        figure7.addCell(f7, cA);
        figure7.addCell(g7, cA);
        figure7.addCell(h7, cA);
        Figures figures7 = new Figures(Set.of(figure7));
        assertEquals(figures7, slice7.getThreeInARowCells());
    }

}
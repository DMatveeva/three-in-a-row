package threeinarow.matrix.realization;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Срез части Cells
 */
public class Figure extends AbstractFigure {

    Map<CartesianCoordinate, Cell> cells;

    public Figure(HashMap<CartesianCoordinate, Cell> cells) {
        this.cells = Map.copyOf(cells);
    }

    public Figure() {
    }

    @Override
    public int size() {
        return cells.size();
    }

    public void addCell(CartesianCoordinate cc, Cell cell) {
        cells.put(cc, cell);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(cells, figure.cells);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cells);
    }

    @Override
    public String toString() {
        return cells.entrySet().stream()
                .map(entry -> String.format("%s_%s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(";"));
    }


    //команды

}

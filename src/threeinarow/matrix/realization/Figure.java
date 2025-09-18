package threeinarow.matrix.realization;

import java.util.*;
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
        this.cells = new HashMap<>();
    }

    @Override
    public int size() {
        return cells.size();
    }

    public void addCell(CartesianCoordinate cc, Cell cell) {
        cells.put(cc, cell);
    }

    public Figures superimpose(Figure other) {
        Set<CartesianCoordinate> otherKeys = other.cells.keySet();
        Set<CartesianCoordinate> thisKeys = this.cells.keySet();
        boolean intersect = otherKeys.stream()
                .anyMatch(thisKeys::contains);
        if(intersect) {
            HashMap<CartesianCoordinate, Cell> newCells = new HashMap<>();
            newCells.putAll(this.cells);
            newCells.putAll(other.cells);
            Figure newFigure = new Figure(newCells);
            return new Figures(List.of(newFigure));
        }
        return new Figures(List.of(this, other));
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
                .collect(Collectors.joining(" | "));
    }


    //команды

}

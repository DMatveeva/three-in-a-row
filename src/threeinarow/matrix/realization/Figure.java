package threeinarow.matrix.realization;

import java.util.*;
import java.util.stream.Collectors;

import static java.awt.geom.Rectangle2D.intersect;

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

    public boolean intersects(Figure other) {
        Set<CartesianCoordinate> otherKeys = other.cells.keySet();
        Set<CartesianCoordinate> thisKeys = this.cells.keySet();
        return otherKeys.stream()
                .anyMatch(thisKeys::contains);
    }

    public Figure superimpose(Figure other) {

        if(this.intersects(other)) {
            HashMap<CartesianCoordinate, Cell> newCells = new HashMap<>();
            newCells.putAll(this.cells);
            newCells.putAll(other.cells);
            return new Figure(newCells);
        }
        return this;
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
        return cells.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(entry -> String.format("%s_%s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" | "));
    }


    //команды

}

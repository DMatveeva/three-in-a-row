package threeinarow.matrix.realization;

import java.util.*;
import java.util.stream.Collectors;

public class CellSlice extends AbstractFigure {

    Map<CartesianCoordinate, Cell> coordinateToCell;

    public CellSlice(LinkedHashMap<CartesianCoordinate, Cell> cells) {
        this.coordinateToCell = Collections.unmodifiableMap(new LinkedHashMap<>(cells));
    }

    public Figures getThreeInARowCells() {

        Collection<CartesianCoordinate> keys = coordinateToCell.keySet();
        Iterator<CartesianCoordinate> iterator = keys.iterator();

        Set<Figure> allFigures = new HashSet<>();
        Figure currentFigure = new Figure();

        CartesianCoordinate prevCoordinate = iterator.next();
        Cell prevCell = coordinateToCell.get(prevCoordinate);
        currentFigure.addCell(prevCoordinate, prevCell);

        while (iterator.hasNext()) {
            CartesianCoordinate currentCoordinate = iterator.next();
            Cell currentCell = coordinateToCell.get(currentCoordinate);

            if(currentCell.equals(prevCell)) {
                currentFigure.addCell(currentCoordinate, currentCell);
            } else {
                allFigures.add(currentFigure);
                currentFigure = new Figure();
                currentFigure.addCell(currentCoordinate, currentCell);
            }
            prevCell = currentCell;
        } //TODO
        allFigures.add(currentFigure);
        Set<Figure> figuresBiggerThan3 = allFigures.stream().filter(f -> f.size() >= 3).collect(Collectors.toSet());
        if(figuresBiggerThan3.isEmpty()) {
            return Figures.empty();
        }
        return new Figures(figuresBiggerThan3);

    }

    @Override
    public int size() {
        return coordinateToCell.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellSlice cellSlice = (CellSlice) o;
        return Objects.equals(coordinateToCell, cellSlice.coordinateToCell);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinateToCell);
    }

    @Override
    public String toString() {
        return coordinateToCell.entrySet().stream()
                .map(entry -> String.format("%s_%s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" | "));
    }
}

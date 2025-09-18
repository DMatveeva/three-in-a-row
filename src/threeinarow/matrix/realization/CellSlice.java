package threeinarow.matrix.realization;

import java.util.*;

public class CellSlice extends AbstractFigure {

    Map<CartesianCoordinate, Cell> coordinateToCell;
    public CellSlice(LinkedHashMap<CartesianCoordinate, Cell> cells) {
        this.coordinateToCell = Map.copyOf(cells);
    }

    public Figures getSequencedCells() {

        Collection<CartesianCoordinate> keys = coordinateToCell.keySet();
        Iterator<CartesianCoordinate> iterator = keys.iterator();

        List<Figure> allFigures = new ArrayList<>();
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
        } //TODO
        allFigures.add(currentFigure);
        List<Figure> figuresBiggerThan3 = allFigures.stream().filter(f -> f.size() < 3).toList();
        return new Figures(figuresBiggerThan3);

    }

    @Override
    public int size() {
        return coordinateToCell.size();
    }

}

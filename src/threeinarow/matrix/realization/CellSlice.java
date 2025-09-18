package threeinarow.matrix.realization;

import java.util.*;
import java.util.stream.Collectors;

public class CellSlice extends AbstractFigure {

    private Coordinate basis;
    private final LinkedHashMap<CartesianCoordinate, Cell> coordinateToCell; //TREE SET

    public CellSlice(LinkedHashMap<CartesianCoordinate, Cell> cells) {
        this.coordinateToCell = new LinkedHashMap<>(cells);
    }

    public Cell getByCoordinate(CartesianCoordinate c) {
        return coordinateToCell.get(c);
    }

    //TODO
    public CellSlice copyWithEmptyCellsFilled() {

        Collection<Cell> cells = coordinateToCell.values();
        List<Cell> notEmptyCells = new ArrayList<>();
        for (Cell cell: cells) {
            if(!cell.isEmpty()) {
                notEmptyCells.add(cell);
            }
        }

        int initialSize = coordinateToCell.size();
        int notEmptySize = notEmptyCells.size();
        int emptySize = initialSize - notEmptySize;

        Random random = new Random();
        List<Cell> randomCells = new ArrayList<>();
        for (int i = 0; i < emptySize; i++) {
            List<Letter> letters = Letter.getNotEmpty();
            int randomIndex = random.nextInt(letters.size());
            Letter l = letters.get(randomIndex);
            randomCells.add(new Cell(l));
        }

        List<Cell> newCells = new ArrayList<>();
        newCells.addAll(randomCells);
        newCells.addAll(notEmptyCells);

        LinkedHashMap<CartesianCoordinate, Cell> newMap = new LinkedHashMap<>();
        Iterator<Cell> iterator = newCells.iterator();

        Set<CartesianCoordinate> keys = coordinateToCell.keySet();
        for (CartesianCoordinate cc: keys) {
            newMap.put(cc, iterator.next());
        }

        return new CellSlice(newMap);
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

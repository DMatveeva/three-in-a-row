package threeinarow.matrix.atd.impl;

import threeinarow.matrix.atd.Cells;
import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.Coordinate;
import threeinarow.matrix.realization.UIMatrixCells;

import java.util.LinkedHashMap;
import java.util.List;

public class GameCells extends Cells {

    private LinkedHashMap<Coordinate, Cell> cells;

    public GameCells(LinkedHashMap<Coordinate, Cell> cells) {
        this.cells = cells;
    }

    //запросы
    public Cell getByCoordinate(Coordinate coordinate) {
        return cells.get(coordinate);
    }

    @Override
    public UIMatrixCells getUiRepresentation() {
        int width = Coordinate.getMaxWidth();
        String[][] uiCells = new String[width][width];
        Coordinate[] coordinates = Coordinate.values();
        for(int i = 0; i < Coordinate.getCount(); i++) {
            int x = i % width;
            int y = i / width;
            Coordinate coordinate = coordinates[i];
            Cell cell = cells.get(coordinate);
            uiCells[x][y] = cell.getValueForUI();
        }
        return new UIMatrixCells(uiCells);
    }


    //команды

    //предусловие: other != this
    //постусловие: значение в узлах поменялись местами
    public void swapValues(Coordinate from, Coordinate to) {}

    //предусловие: в хранилище есть ключ = key
    public void updateCellValue(Coordinate key, Cell value) {}

    //предусловие: в хранилище есть ключ = key
    public void emptyCell(Coordinate key) {}
}

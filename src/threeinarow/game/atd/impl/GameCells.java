package threeinarow.game.atd.impl;

import threeinarow.game.atd.Cells;
import threeinarow.game.realization.Cell;
import threeinarow.game.realization.Coordinate;
import threeinarow.game.realization.UIMatrixCells;

import java.util.LinkedHashMap;
import java.util.List;

public class GameCells extends Cells {

    private LinkedHashMap<Coordinate, Cell> cells;

    GameCells(LinkedHashMap<Coordinate, Cell> cells) {
        this.cells = cells;
    }

    //запросы
    public Cell getByCoordinate(Coordinate coordinate) {
        return cells.get(coordinate);
    }

    @Override
    public UIMatrixCells forUI() {
        return null;
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

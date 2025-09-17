package threeinarow.matrix.atd.impl;

import threeinarow.matrix.atd.Cells;
import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.UICells;

import java.util.LinkedHashMap;
import java.util.List;

public class GameCells extends Cells {

    private LinkedHashMap<CartesianCoordinate, Cell> cells;

    public GameCells(LinkedHashMap<CartesianCoordinate, Cell> cells) {
        this.cells = cells;
    }

    //запросы
    public Cell getByCoordinate(CartesianCoordinate cartesianCoordinate) {
        return cells.get(cartesianCoordinate);
    }

    @Override
    public UICells getUiRepresentation() {
        int width = CartesianCoordinate.getMaxWidth();
        String[][] uiCells = new String[width][width];
        List<CartesianCoordinate> cartesianCoordinates = CartesianCoordinate.values(); //TODO
        //TODO
        for(int i = 0; i < cells.size(); i++) {
            int x = i / width;
            int y = i % width;
            CartesianCoordinate c = cartesianCoordinates.get(i);
            Cell cell = cells.get(c);
            uiCells[x][y] = cell.getValueForUI();
        }
        return new UICells(uiCells);
    }


    //команды

    //предусловие: other != this
    //постусловие: значение в узлах поменялись местами
    public void swapValues(CartesianCoordinate from, CartesianCoordinate to) {
        if(!cells.containsKey(from) || !cells.containsKey(to)) {

        }
        Cell fromCell = cells.get(from);
        Cell toCell = cells.get(to);
        cells.put(from, toCell);
        cells.put(to, fromCell);
    }

    //предусловие: в хранилище есть ключ = key
    public void updateCellValue(CartesianCoordinate key, Cell value) {}

    //предусловие: в хранилище есть ключ = key
    public void emptyCell(CartesianCoordinate key) {}
}

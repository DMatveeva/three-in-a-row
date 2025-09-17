package threeinarow.matrix.atd.impl;

import threeinarow.matrix.atd.Cells;
import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.UICells;

import java.util.LinkedHashMap;
import java.util.List;
public class GameCells extends Cells {

    private final LinkedHashMap<CartesianCoordinate, Cell> cells;
    private int swapValuesStatus;

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
        List<CartesianCoordinate> cartesianCoordinates = CartesianCoordinate.values();
        for (CartesianCoordinate c: cartesianCoordinates) {
            int x = c.getX();
            int y = c.getY();
            Cell cell = cells.get(c);
            uiCells[y][x] = cell.getValueForUI();
        }
        return new UICells(uiCells);
    }

    //команды
    @Override
    public void swapValues(CartesianCoordinate from, CartesianCoordinate to) {
        if(! cells.containsKey(from) || !cells.containsKey(to)) {
            swapValuesStatus = SWAP_VALUES_STATUS_ERR;
            return;
        }
        Cell fromCell = cells.get(from);
        Cell toCell = cells.get(to);
        cells.put(from, toCell);
        cells.put(to, fromCell);
        swapValuesStatus = SWAP_VALUES_STATUS_OK;
    }

    //предусловие: в хранилище есть ключ = key
    public void emptyCell(CartesianCoordinate key) {}

    //статусы
    @Override
    public int getSwapValuesStatus() { return swapValuesStatus; }
}

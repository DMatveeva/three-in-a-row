package threeinarow.matrix.atd.impl;

import threeinarow.matrix.atd.Cells;
import threeinarow.matrix.realization.*;

import java.util.*;
import java.util.stream.Collectors;

public class GameCells extends Cells {

    private final LinkedHashMap<CartesianCoordinate, Cell> cells;
    private int swapValuesStatus;

    public GameCells(LinkedHashMap<CartesianCoordinate, Cell> cells) {
        this.cells = cells;
    }

    //запросы
    @Override
    public Cell getByCoordinate(CartesianCoordinate cartesianCoordinate) {
        return cells.get(cartesianCoordinate);
    }

    public Collection<CellSlice> getRows() {
        //aa ba ca da...
        Collection<CellSlice> slices = new ArrayList<>();
        for(Coordinate x: Coordinate.values()) {
            LinkedHashMap<CartesianCoordinate, Cell> cellSliceMap = new LinkedHashMap<>();
            for (Coordinate y: Coordinate.values()) {
                CartesianCoordinate xy = new CartesianCoordinate(x, y);
                Cell cell = cells.get(xy);
                cellSliceMap.put(xy, cell);
            }
            CellSlice cellSlice = new CellSlice(cellSliceMap);
            slices.add(cellSlice);
        } //TODO
        return slices;
    }


    @Override
    public UICells getUiRepresentation() {
        int width = CartesianCoordinate.getMaxWidth();
        String[][] uiCells = new String[width][width];
        List<CartesianCoordinate> cartesianCoordinates = CartesianCoordinate.values();
        for (CartesianCoordinate c : cartesianCoordinates) {
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
        if (!cells.containsKey(from) || !cells.containsKey(to)) {
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
    public void emptyCell(CartesianCoordinate key) {
    }

    //статусы
    @Override
    public int getSwapValuesStatus() {
        return swapValuesStatus;
    }
}

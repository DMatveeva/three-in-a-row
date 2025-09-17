package threeinarow.matrix.atd;

import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.UICells;

public abstract class Cells {

    public final static int SWAP_VALUES_STATUS_OK = 1;
    public final static int SWAP_VALUES_STATUS_ERR = 2;

    public Cells() {

    }

    //запросы

    //предусловие: хранилище содержит клетку с такой координатой
    public abstract Cell getByCoordinate(CartesianCoordinate cartesianCoordinate);

    public abstract UICells getUiRepresentation();

    //команды

    //предусловие: other != this
    //постусловие: значение в узлах поменялись местами
    public abstract void swapValues(CartesianCoordinate from, CartesianCoordinate to);

    //предусловие: в хранилище есть ключ = key
    public abstract void updateCellValue(CartesianCoordinate key, Cell value);

    //предусловие: в хранилище есть ключ = key
    public abstract void emptyCell(CartesianCoordinate key);

    //status
    public abstract int getSwapStatus();
}

package threeinarow.matrix.atd;

import threeinarow.matrix.realization.*;

import java.util.Collection;

public abstract class Cells {

    public final static int SWAP_VALUES_STATUS_OK = 1;
    public final static int SWAP_VALUES_STATUS_ERR = 2;

    public Cells() {

    }

    //запросы

    //предусловие: хранилище содержит клетку с такой координатой
    public abstract Cell getByCoordinate(CartesianCoordinate cartesianCoordinate);

    public abstract UICells getUiRepresentation();

    public abstract CellSlices getRows();

    public abstract CellSlices getColumns();


    //команды

    //предусловие: other != this, from, to - есть в хранилище
    //постусловие: значение в узлах поменялись местами
    public abstract void swapValues(CartesianCoordinate from, CartesianCoordinate to);

    //предусловие: в хранилище есть ключ = key
    public abstract void emptyCell(CartesianCoordinate key);

    public abstract void fillEmptyCellsForColumn(Coordinate x, CellSlice slice);

    //status
    public abstract int getSwapValuesStatus();
}

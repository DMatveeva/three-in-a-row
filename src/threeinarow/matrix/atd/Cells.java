package threeinarow.matrix.atd;

import threeinarow.matrix.realization.Cell;
import threeinarow.matrix.realization.Coordinate;
import threeinarow.matrix.realization.UIMatrixCells;

public abstract class Cells {

    public Cells() {

    }

    //запросы

    //предусловие: хранилище содержит клетку с такой координатой
    public abstract Cell getByCoordinate(Coordinate coordinate);

    public abstract UIMatrixCells getUiRepresentation();

    //команды

    //предусловие: other != this
    //постусловие: значение в узлах поменялись местами
    public abstract void swapValues(Coordinate from, Coordinate to);

    //предусловие: в хранилище есть ключ = key
    public abstract void updateCellValue(Coordinate key, Cell value);

    //предусловие: в хранилище есть ключ = key
    public abstract void emptyCell(Coordinate key);
}

package threeinarow.game.atd;

import threeinarow.game.realization.AbstractCell;
import threeinarow.game.realization.Coordinate;
import threeinarow.game.realization.UIMatrixCells;

import java.util.List;

public abstract class MatrixCells {

    MatrixCells(List<AbstractCell> cells) {

    }

    //запросы
    public abstract AbstractCell getByCoordinate(Coordinate coordinate);

    public abstract UIMatrixCells forUI();

    //команды

    //предусловие: other != this
    //постусловие: значение в узлах поменялись местами
    public abstract void swapValues(Coordinate from, Coordinate to);

    //предусловие: в хранилище есть ключ = key
    public abstract void updateCellValue(Coordinate key, AbstractCell value);

    //предусловие: в хранилище есть ключ = key
    public abstract void emptyCell(Coordinate key);
}

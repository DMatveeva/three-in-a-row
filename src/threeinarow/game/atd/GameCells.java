package threeinarow.game.atd;

import threeinarow.game.realization.AbstractCell;
import threeinarow.game.realization.Coordinate;
import threeinarow.game.realization.UIMatrixCells;

import java.util.LinkedHashMap;
import java.util.List;

public class GameCells extends MatrixCells {

    private LinkedHashMap<Coordinate, AbstractCell> cells;

    GameCells(List<AbstractCell> cells) {
        super(cells);
    }

    //запросы
    public AbstractCell getByCoordinate(Coordinate coordinate);


    //команды

    //предусловие: other != this
    //постусловие: значение в узлах поменялись местами
    public void swapValues(Coordinate from, Coordinate to);

    //предусловие: в хранилище есть ключ = key
    public void updateCellValue(Coordinate key, AbstractCell value);

    //предусловие: в хранилище есть ключ = key
    public void emptyCell(Coordinate key);
}

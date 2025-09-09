package threeinarow.game.matrix;

import threeinarow.game.Coordinate;

public abstract class Cell {

    // создает Cell c координатой
    public Cell (Coordinate coordinate) {

    }

    //запросы

    public abstract boolean isEmpty();

    // команды

    //предусловие: other != this
    //постусловие: значение в клетках поменялись местами
    public abstract void update(Cell other);
}

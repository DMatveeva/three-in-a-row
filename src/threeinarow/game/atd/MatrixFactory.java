package threeinarow.game.atd;

import threeinarow.game.realization.Coordinate;

/**
 * АТД - абстрактная фабрика для создания АТД Matrix и MatrixCells
 */
public abstract class MatrixFactory {

    //запросы
    public abstract Matrix createMatrix();

    public abstract Cells createMatrixCells();

}


package threeinarow.game.atd;


import threeinarow.game.realization.Coordinate;
import threeinarow.game.realization.Figures;
import threeinarow.game.realization.UIMatrixCells;

/**
 * АТД
 */
public abstract class Matrix {

    //запросы

    //предусловие: матрица непустая
    public abstract boolean containsFigures();

    //предусловие: матрица непустая
    public abstract Figures getFigures();

    public abstract UIMatrixCells getCellsForUI();

    //команды

    //предусловие: есть пустые клетки
    //постусловие: все клетки заполнены
    public abstract void fillEmptyCells(); //printerManager.notify(this, FILL_CELLS_COMMAND)

    //предусловие: from и to находятся внутри матрицы
    //постусловие: значения в клетах поменялись местами
    public abstract void swapCells(Coordinate from, Coordinate to);

    //предусловие: figures находятся внутри матрицы
    //постусловие: figures пустые
    public abstract void cleanFigures(Figures figures); // notify(this, figures)

    //постусловие: матрица очищена
    public abstract void clear();
}

package threeinarow.game.matrix;


import threeinarow.game.Coordinate;
import threeinarow.game.Figures;

/**
 * АТД
 */
public abstract class Matrix {

    //запросы

    //предусловие: матрица непустая
    public abstract boolean containsFigures();

    //предусловие: матрица непустая
    public abstract Figures getFigures();

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

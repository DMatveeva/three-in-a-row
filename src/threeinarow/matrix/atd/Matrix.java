package threeinarow.matrix.atd;


import threeinarow.matrix.realization.Coordinate;
import threeinarow.matrix.realization.Figures;
import threeinarow.matrix.realization.UIMatrixCells;

/**
 * АТД
 */
public abstract class Matrix {


    //запросы

    //предусловие: матрица непустая
    public abstract boolean containsFigures();

    //предусловие: матрица непустая
    public abstract Figures getFigures();

    public abstract String getViewForUI();

    //команды

    //постусловие: все клетки заполнены
    public abstract void fillEmptyCells(); //printerManager.notify(this, FILL_CELLS_COMMAND)

    //постусловие: значения в клетах поменялись местами
    public abstract void swapCells(Coordinate from, Coordinate to);

    //предусловие: figures находятся внутри матрицы
    //постусловие: figures пустые
    public abstract void cleanFigures(Figures figures); // notify(this, figures)

    //постусловие: матрица очищена
    public abstract void clear();
}

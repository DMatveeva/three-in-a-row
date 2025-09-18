package threeinarow.matrix.atd;


import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.Figures;

/**
 * АТД
 */
public abstract class Matrix {

    //  public final static int SWAP_CELL_STATUS_NIL = 0; // клетки в данном
    public final static int SWAP_CELL_STATUS_OK = 1; // клетки успешно поменялись
    public final static int SWAP_CELL_STATUS_ERR = 2; // клетки не соседи

    protected int swapCellStatus;

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
    public abstract void swapCells(CartesianCoordinate from, CartesianCoordinate to);

    //предусловие: figures находятся внутри матрицы
    //постусловие: figures пустые
    public abstract void cleanFigures(Figures figures); // notify(this, figures)


    public int getSwapCellStatus() {
        return swapCellStatus;
    }
}

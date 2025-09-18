package threeinarow.matrix.atd.impl;

import threeinarow.matrix.atd.Cells;
import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.realization.*;

import java.util.Collection;

public class GameMatrix extends Matrix {

    private Cells cells;
    private AdjacencyMatrix adjacencyMatrix;

    private int swapStatus;

    public GameMatrix(GameCells cells, AdjacencyMatrix adjacencyMatrix) {
        this.cells = cells;
        this.adjacencyMatrix = adjacencyMatrix;

    }

    @Override
    public boolean containsFigures() {

        return false;
    }

    @Override
    public Figures getFigures() {
        Collection<CellSlice> rows = cells.getRows();
        Figures rowFigures = rows.stream()
                .map(CellSlice::getSequencedCells)
                .reduce(Figures.empty(), Figures::union);


        return null;
    }

    @Override
    public String getViewForUI() {
        return cells.getUiRepresentation().asString();
    }

    @Override
    public void fillEmptyCells() {
    }

    @Override
    public void swapCells(CartesianCoordinate from, CartesianCoordinate to) {
        boolean areNeighbours = from.isNeighbour(to);
        if(!areNeighbours) {
            swapCellStatus = SWAP_CELL_STATUS_ERR;
            return;
        }
        cells.swapValues(from, to);
        if(cells.getSwapValuesStatus() == Cells.SWAP_VALUES_STATUS_ERR) {
            swapCellStatus = SWAP_CELL_STATUS_ERR;
            return;
        }
        swapCellStatus = SWAP_CELL_STATUS_OK;
    }


    @Override
    public void cleanFigures(Figures figures) {
    }

    @Override
    public void clear() {

    }

    //status
}


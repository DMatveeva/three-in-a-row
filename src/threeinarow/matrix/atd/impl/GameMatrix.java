package threeinarow.matrix.atd.impl;

import threeinarow.matrix.atd.Cells;
import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.realization.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class GameMatrix extends Matrix {

    private final Cells cells;
  //  private AdjacencyMatrix adjacencyMatrix;

    private int swapStatus;

    public GameMatrix(GameCells cells, AdjacencyMatrix adjacencyMatrix) {
        this.cells = cells;
   //     this.adjacencyMatrix = adjacencyMatrix;
    }

    @Override
    public boolean containsFigures() {
        return !this.getFigures().isEmpty();
    }

    @Override
    public Figures getFigures() {
        Figures rowFigures = cells.getRows().getSlices().stream()
                .map(CellSlice::getThreeInARowCells)
                .reduce(Figures.empty(), Figures::union);

        Figures columnFigures = cells.getColumns().getSlices().stream()
                .map(CellSlice::getThreeInARowCells)
                .reduce(Figures.empty(), Figures::union);

        return rowFigures.superimpose(columnFigures);
    }

    @Override
    public String getViewForUI() {
        return cells.getUiRepresentation().asString();
    }

    @Override
    public void fillEmptyCells() {
        CellSlices slices = cells.getColumns();
        for (Coordinate x: Coordinate.values()) {
            CellSlice slice = slices.getByCoordinate(x);
            CellSlice newSlice = slice.copyWithEmptyCellsFilled();
            cells.fillEmptyCellsForColumn(x, newSlice);
        }
    }

    @Override
    public void swapCells(CartesianCoordinate from, CartesianCoordinate to) {
        boolean areNeighbours = from.isNeighbour(to);
        if (!areNeighbours) {
            swapCellStatus = SWAP_CELL_STATUS_ERR;
            return;
        }
        cells.swapValues(from, to);
        if (cells.getSwapValuesStatus() == Cells.SWAP_VALUES_STATUS_ERR) {
            swapCellStatus = SWAP_CELL_STATUS_ERR;
            return;
        }
        swapCellStatus = SWAP_CELL_STATUS_OK;
    }


    @Override
    public void cleanFigures(Figures figures) {
        Set<CartesianCoordinate> coordinates = figures.getCoordinates();
        coordinates.forEach(cells::emptyCell);
    }

    //status
}


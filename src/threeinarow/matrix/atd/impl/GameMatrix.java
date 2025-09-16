package threeinarow.matrix.atd.impl;

import threeinarow.matrix.atd.Cells;
import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.realization.*;

public class GameMatrix extends Matrix {

    Cells cells;
    AdjacencyMatrix adjacencyMatrix;

    public GameMatrix(GameCells cells, AdjacencyMatrix adjacencyMatrix) {

    }

    @Override
    public boolean containsFigures() {

        return false;
    }

    @Override
    public Figures getFigures() {
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
    public void swapCells(Coordinate from, Coordinate to) {

    }

    @Override
    public void cleanFigures(Figures figures) {
    }

    @Override
    public void clear() {

    }
}


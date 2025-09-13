package threeinarow.game.atd.impl;

import threeinarow.game.atd.Matrix;
import threeinarow.game.realization.*;

import java.util.LinkedHashMap;

public class GameMatrix extends Matrix {



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
    public UIMatrixCells getCellsForUI() {
        return null;
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


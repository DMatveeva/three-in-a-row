package threeinarow.game.atd;

import threeinarow.game.realization.Coordinate;
import threeinarow.game.realization.Figures;
import threeinarow.game.realization.Letter;

import java.util.LinkedHashMap;

public class GameMatrix extends Matrix {

    private LinkedHashMap<Coordinate, Letter> cells;
    private int [][] adjacencyMatrix = new int [64] [64];

    public GameMatrix(LinkedHashMap<Coordinate, Letter> cells, int[][] adjacencyMatrix) {
        this.cells = cells;
        this.adjacencyMatrix = adjacencyMatrix;
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


package threeinarow.game;

import threeinarow.graph.SearchGraph;
import threeinarow.graph.Subgraph;

import java.util.LinkedHashMap;
import java.util.List;

public class GameMatrix extends Matrix {

    private LinkedHashMap<Coordinate, Letter> cells;
    private int [][] adjacencyMatrix = new int [64] [64];

    public GameMatrix(LinkedHashMap<Coordinate, Letter> cells, int[][] adjacencyMatrix) {
        this.cells = cells;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    @Override
    public boolean containsFigures() {
        SearchGraph<Letter> searchGraph = new SearchGraph<>(cells.values().toArray(new Letter[0]), adjacencyMatrix);
        List<Subgraph> subgraphs = searchGraph.getSubgraphs();

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


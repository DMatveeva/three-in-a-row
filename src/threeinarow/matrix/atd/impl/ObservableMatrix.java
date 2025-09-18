package threeinarow.matrix.atd.impl;

import threeinarow.bonus.BonusAccount;
import threeinarow.common.observer.PrinterListener;
import threeinarow.common.observer.EventManager;
import threeinarow.common.observer.OperationType;
import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.atd.impl.factory.GameMatrixFactory;
import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.Figures;

public class ObservableMatrix extends Matrix {

    EventManager eventManager;
    GameMatrix gameMatrix;

    public ObservableMatrix(GameMatrix gameMatrix, BonusAccount bonusAccount) {
        GameMatrixFactory gameMatrixFactory = GameMatrixFactory.getInstance();
        this.gameMatrix = gameMatrix;
        this.eventManager = new EventManager();
        eventManager.subscribe(OperationType.PRINT, new PrinterListener());
        eventManager.notify(OperationType.PRINT, this.gameMatrix);
    }

    @Override
    public boolean containsFigures() {
        return gameMatrix.containsFigures();
    }

    @Override
    public Figures getFigures() {
        return gameMatrix.getFigures();
    }

    @Override
    public String getViewForUI() {
        return gameMatrix.getViewForUI();
    }

    @Override
    public void fillEmptyCells() {
        gameMatrix.fillEmptyCells();
        eventManager.notify(OperationType.PRINT, gameMatrix);
    }

    @Override
    public void swapCells(CartesianCoordinate from, CartesianCoordinate to) {
        gameMatrix.swapCells(from, to);
        eventManager.notify(OperationType.PRINT, gameMatrix);
    }

    @Override
    public void cleanFigures(Figures figures) {
        gameMatrix.cleanFigures(figures);
        eventManager.notify(OperationType.PRINT, gameMatrix);
    }
}

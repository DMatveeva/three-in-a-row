package threeinarow.game;

import threeinarow.common.command.Command;
import threeinarow.common.command.CommandFactory;
import threeinarow.common.command.CommandHistory;
import threeinarow.common.command.SwapCommand;
import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.atd.impl.factory.GameMatrixFactory;
import threeinarow.matrix.realization.Coordinate;
import threeinarow.matrix.realization.Figures;

import java.util.Scanner;

import static threeinarow.matrix.realization.GameConstants.COORDINATE_INPUT_PATTERN;

public class Game extends GameWithHistory {

    //   private final Matrix matrix;
//    private final CommandHistory commandHistory;
//    //  private final Figures figures;
//
//    protected GameWithHistory() {
//        GameMatrixFactory gameMatrixFactory = GameMatrixFactory.getInstance();
//        this.matrix = gameMatrixFactory.createMatrix();
//        this.commandHistory = new CommandHistory();
//    }
//
//    @Override
//    public void showStepHistory() {
//
//    }
//
//    @Override
//    public void getFiguresAfterRound() {
//
//    }
//
//    //команды
//    @Override
//    public void checkCoordinates() {
//        Command command = this.getLastCommand();
//
//        if(matrix.possibleToswap() = ERR) {
//            enterCoordinatesStatus = ENTER_COORDINATES_ERR;
//        }
//        enterCoordinatesStatus = ENTER_COORDINATES_OK;
//    }
//
//    @Override
//    public void executeRound() {
//        Command swap = commandHistory.peek();
//        swap.execute();
//
//        boolean containsFigures = matrix.containsFigures();
//        if(!containsFigures) {
//            executeRoundStatus = EXECUTE_ROUND_ERR;
//            return;
//        }
//        executeRoundStatus = EXECUTE_ROUND_OK;
//
//        while (containsFigures()) {
//            Figures figures = matrix.getFigures();
//            this.figures = figures;
//            matrix.cleanFigures(figures);
//            matrix.fillEmptyCells();
//        }
//    }
}

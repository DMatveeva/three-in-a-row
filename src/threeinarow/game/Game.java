package threeinarow.game;


import threeinarow.common.command.Command;
import threeinarow.common.command.CommandFactory;
import threeinarow.common.command.CommandHistory;
import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.atd.impl.factory.GameMatrixFactory;
import threeinarow.matrix.realization.CartesianCoordinate;
import threeinarow.matrix.realization.Figures;

import java.util.Scanner;

import static threeinarow.matrix.realization.GameConstants.COORDINATE_INPUT_PATTERN;

/**
 * АТД
 */
public class Game extends AbstractGame {

    private final Matrix matrix;
    private final CommandHistory commandHistory;
    private Figures figures; //TODO only 2 in class!

    protected Game() {
        GameMatrixFactory gameMatrixFactory = GameMatrixFactory.getInstance();
        this.matrix = gameMatrixFactory.createMatrix();
        this.commandHistory = new CommandHistory();
    }

    @Override
    public void showStepHistory() {
    }

    @Override
    public Figures getFiguresAfterRound() {
        return figures;
    }

    Command getLastCommand() {
        return commandHistory.peek();
    }

    //команды
    @Override
    public void enterCoordinates() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        boolean matches = s.matches(COORDINATE_INPUT_PATTERN);
        if (!matches) {
            enterCoordinatesStatus = ENTER_COORDINATES_ERR;
            return;
        }
        String[] parts = s.split(" ");
        String from = parts[0];
        String to = parts[1];
        Command swap = CommandFactory.getInstance().createSwapCommand(matrix, CartesianCoordinate.fromUI(from), CartesianCoordinate.fromUI(to));
        commandHistory.push(swap);
        enterCoordinatesStatus = ENTER_COORDINATES_OK;
    }

    @Override
    public void executeRound() {
        Command swap = commandHistory.peek();
        swap.execute();

        boolean containsFigures = matrix.containsFigures();
        if(!containsFigures) {
            executeRoundStatus = EXECUTE_ROUND_ERR;
            return;
        }
        executeRoundStatus = EXECUTE_ROUND_OK;

        while (matrix.containsFigures()) {
            Figures figures = matrix.getFigures();
            this.figures = figures;
            matrix.cleanFigures(figures);
            matrix.fillEmptyCells();
        }
    }
}

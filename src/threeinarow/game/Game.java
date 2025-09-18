package threeinarow.game;


import threeinarow.common.command.Command;
import threeinarow.common.command.CommandFactory;
import threeinarow.common.command.CommandHistory;
import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.atd.impl.GameMatrix;
import threeinarow.matrix.atd.impl.ObservableMatrix;
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
    private Figures figures = Figures.empty();
    private Scanner input = new Scanner(System.in); //TODO only 2 in class!

    protected Game() {
        GameMatrixFactory gameMatrixFactory = GameMatrixFactory.getInstance();
        GameMatrix gameMatrix = gameMatrixFactory.createMatrix();
        this.matrix = new ObservableMatrix(gameMatrix);
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
        String s = input.nextLine();
        boolean matches = s.matches(COORDINATE_INPUT_PATTERN);
        if (!matches) {
            enterCoordinatesStatus = ENTER_COORDINATES_PARSE_ERR;
            return;
        }
        String[] parts = s.split(" ");
        String from = parts[0];
        String to = parts[1];
        CartesianCoordinate fromC = CartesianCoordinate.fromUI(from);
        CartesianCoordinate toC = CartesianCoordinate.fromUI(to);
        if(!fromC.isNeighbour(toC)) {
            enterCoordinatesStatus = ENTER_COORDINATES_SWAP_ERR;
            return;
        }
        Command swap = CommandFactory.getInstance().createSwapCommand(matrix, fromC, toC);
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
            this.figures = figures.union(this.figures);
            System.out.println(this.figures.getCoordinates().size());
            matrix.cleanFigures(figures);
            matrix.fillEmptyCells();
        }
        enterCoordinatesStatus = ENTER_COORDINATES_NIL;
    }

    @Override
    public int getEnterCoordinatesStatus() {
        return enterCoordinatesStatus;
    }

    @Override
    public int getExecuteRoundStatus() {
        return executeRoundStatus;
    }
}

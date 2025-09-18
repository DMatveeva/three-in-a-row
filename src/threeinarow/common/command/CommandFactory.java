package threeinarow.common.command;

import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.realization.CartesianCoordinate;

public class CommandFactory {

    private static final CommandFactory INSTANCE = new CommandFactory();

    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    public SwapCommand createSwapCommand(Matrix matrix, CartesianCoordinate from, CartesianCoordinate to) {
        return new SwapCommand(matrix, from, to);
    }

}

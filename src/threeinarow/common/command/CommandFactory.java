package threeinarow.common.command;

import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.realization.Coordinate;

public class CommandFactory {

    private static final CommandFactory INSTANCE = new CommandFactory();

    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    public SwapCommand createSwapCommand(Matrix matrix, Coordinate from, Coordinate to) {
        return new SwapCommand();
    }

}

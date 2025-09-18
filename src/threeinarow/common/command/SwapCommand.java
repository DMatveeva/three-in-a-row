package threeinarow.common.command;

import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.realization.CartesianCoordinate;

public class SwapCommand extends Command {

    CartesianCoordinate from;
    CartesianCoordinate to;

    public SwapCommand(Matrix matrix, CartesianCoordinate from, CartesianCoordinate to) {
        super(matrix);
        this.from = from;
        this.to = to;
    }


    @Override
    public void execute() {
        matrix.swapCells(from, to);
    }
}

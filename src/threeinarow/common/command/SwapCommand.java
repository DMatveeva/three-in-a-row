package threeinarow.common.command;

import threeinarow.matrix.realization.CartesianCoordinate;

public class SwapCommand extends Command {

    CartesianCoordinate from;
    CartesianCoordinate to;


    @Override
    public void execute() {
        matrix.swapCells(from, to);
    }
}

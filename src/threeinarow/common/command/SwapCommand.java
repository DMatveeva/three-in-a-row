package threeinarow.common.command;

import threeinarow.game.Coordinate;

public class SwapCommand extends Command {

    Coordinate from;
    Coordinate to;


    @Override
    public void execute() {
        matrix.swapCells(from, to);
    }
}

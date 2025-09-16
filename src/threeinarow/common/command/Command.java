package threeinarow.common.command;

import threeinarow.matrix.atd.Matrix;

public abstract class Command {

    protected Matrix matrix;

    public abstract void execute();
}

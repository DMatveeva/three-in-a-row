package threeinarow.common.command;

import threeinarow.matrix.atd.Matrix;

public abstract class Command {

    protected Matrix matrix;

    public Command(Matrix matrix) {
        this.matrix = matrix;
    }

    public abstract void execute();
}

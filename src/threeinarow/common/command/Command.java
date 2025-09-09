package threeinarow.common.command;

import threeinarow.Main;
import threeinarow.game.matrix.Matrix;

public abstract class Command {

    protected Matrix matrix;
    protected Main application;

    public abstract void execute();
}

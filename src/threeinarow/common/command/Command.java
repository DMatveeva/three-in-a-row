package threeinarow.common.command;

import threeinarow.Main;
import threeinarow.game.atd.Matrix;

public abstract class Command {

    protected Matrix matrix;
    protected Main application;

    public abstract void execute();
}

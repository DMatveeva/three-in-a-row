package threeinarow.common.command;

import threeinarow.game.realization.Figures;

public class CleanCommand extends Command {

    Figures figures;

    @Override
    public void execute() {
        matrix.cleanFigures(figures);
    }
}

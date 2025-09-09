package threeinarow.common.command;

public class FillCommand extends Command {
    @Override
    public void execute() {
        matrix.fillEmptyCells();
    }
}

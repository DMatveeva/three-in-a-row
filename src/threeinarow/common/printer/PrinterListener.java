package threeinarow.common.printer;

import threeinarow.game.matrix.Matrix;

public interface PrinterListener {

    public void print(Matrix matrix, CommandType commandType);
}

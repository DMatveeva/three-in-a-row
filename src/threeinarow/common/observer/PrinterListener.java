package threeinarow.common.observer;

import threeinarow.matrix.atd.Matrix;
import threeinarow.matrix.realization.UIMatrixCells;

public class PrinterListener implements Listener {

    public void update(Matrix matrix) {
        String view = matrix.getViewForUI();
        System.out.println(view);
    }
}

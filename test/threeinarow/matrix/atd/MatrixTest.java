package threeinarow.matrix.atd;

import org.junit.jupiter.api.Test;
import threeinarow.matrix.atd.impl.factory.GameMatrixFactory;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    GameMatrixFactory factory = GameMatrixFactory.getInstance();

    @Test
    void test_createMartrix() {
        Matrix matrix = factory.createMatrix();
        String view = matrix.getViewForUI();
        System.out.println(view);
    }

}
package threeinarow.game.atd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import threeinarow.game.atd.impl.GameMatrixFactory;
import threeinarow.game.realization.Coordinate;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameCellsTest {

    List<Coordinate> coordinates = Arrays.stream(Coordinate.values()).toList();

    @Test
    void test_create() {
        MatrixFactory factory = GameMatrixFactory.getInstance();
        Cells matrixCells = factory.createMatrixCells();
        coordinates.stream()
                .map(matrixCells::getByCoordinate)
                .forEach(Assertions::assertNotNull);
    }

//    @Test
//    void test_swapValues() {
//
//
//    }

}
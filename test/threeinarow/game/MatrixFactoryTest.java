package threeinarow.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import threeinarow.game.atd.MatrixFactory;

import static org.junit.jupiter.api.Assertions.*;

class MatrixFactoryTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1, 1",
            "1, 0, 1",
            "0, 2, 0",
            "16, 24, 1",
            "21, 22, 1",
            "22, 15, 0"
    })
    void test_getAdjacencyMatrix(int i, int j, int adjacency) {
        int[][] am = MatrixFactory.getAdjacencyMatrix();
        int actual = am[i][j];
        assertEquals(adjacency, actual);
    }
}
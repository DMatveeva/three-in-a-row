package threeinarow;

import threeinarow.game.atd.Matrix;
import threeinarow.game.atd.MatrixFactory;
import threeinarow.game.atd.impl.GameMatrixFactory;

import java.util.Scanner;


/**
 * АТД
 */
public class ThreeInARowGame {

    public static final ThreeInARowGame INSTANCE = new ThreeInARowGame();

    private ThreeInARowGame() {
        // init params
    }

    public static ThreeInARowGame getInstance() {
        return INSTANCE;
    }


    private static boolean gameOn;

    public void play() {
        GameMatrixFactory factory = GameMatrixFactory.getInstance();
        Matrix matrix = factory.createMatrix();

        while (gameOn) {
            play(matrix);
        }

        matrix.clear();
        System.out.println("Game over");
    }

    private void play(Matrix matrix) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        //проверка ввода, создаем локации
        //Создаем SwapCommand из строки с помощью абстрактной фабрики фабрики

//        SwapCommand swapCommand = CommandCreator.createSwapCommand(this, matrix, s);
//        swapCommand.execute();
//
//        Boolean containsFigures = matrix.containsFigures();
//
//        if(!containsFigures) {
//            gameOn = false;
//        }
//
//        while (matrix.containsFigures()) {
//            Figures figures = matrix.getFigures();
//            CleanCommand cleanCommand = CommandCreator.createCleanCommand(this, matrix, figures);
//            FillCommand generateCommand = CommandCreator.createFillCommand(this, matrix);
//        }
//
}


}

package threeinarow;

import threeinarow.game.atd.Matrix;
import threeinarow.game.atd.MatrixFactory;

import java.util.Scanner;

public class Game {

    public static final Game INSTANCE = new Game();

    private static boolean gameOn;

    public static void play() {
        Matrix matrix = MatrixFactory.create();

        while (gameOn) {
            play(matrix);
        }

        matrix.clear();
        System.out.println("Game over");
    }

    private static void play(Matrix matrix) {
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

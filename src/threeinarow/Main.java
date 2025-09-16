package threeinarow;

import threeinarow.game.GameWithHistory;

import static threeinarow.game.AbstractGame.*;

public class Main {

    public static void main(String[] args) {
//        GameWithHistory game = GameWithHistory.getInstance();
//
//        while (game.getExecuteRoundStatus() == EXECUTE_ROUND_OK) {
//            tryEnterCoordinates(game);
//            game.executeRound();
//        }
//        System.out.println("Game over!");
    }


    public static void tryEnterCoordinates(GameWithHistory game) {
        System.out.println("Enter matrix coordinates:");
        while (game.getEnterCoordinatesStatus() != ENTER_COORDINATES_OK) {
            game.enterCoordinates();
        }
    }

//    private static void printBonuses(Game game) {
//        System.out.print("Your score: ");
//        System.out.println(game.getBonuses());
//    }
}

package threeinarow;

import threeinarow.bonus.BonusAccount;
import threeinarow.game.AbstractGame;
import threeinarow.game.BonusGame;
import threeinarow.game.Game;

import static threeinarow.game.AbstractGame.*;

public class Main {

    public static void main(String[] args) {
        BonusAccount bonusAccount = BonusAccount.getInstance();
        BonusGame game = new BonusGame(bonusAccount);

        while (game.getExecuteRoundStatus() == EXECUTE_ROUND_OK) {
            tryEnterCoordinates(game);
            game.executeRound();
        }
        System.out.println("Game over!");
        System.out.println(String.format("Your bonus = %s", game.getTotalBonus()));
    }


    public static void tryEnterCoordinates(AbstractGame game) {
        while (game.getEnterCoordinatesStatus() != ENTER_COORDINATES_OK) {
            printInfo(game);
            game.enterCoordinates();
        }
    }

    public static void printInfo(AbstractGame game) {
        if(game.getEnterCoordinatesStatus() == ENTER_COORDINATES_NIL) {
            System.out.println("Enter matrix coordinates:");
        }
        if(game.getEnterCoordinatesStatus() == ENTER_COORDINATES_PARSE_ERR) {
            System.out.println("Can't parse coordinates. Try again.");
        }
        if(game.getEnterCoordinatesStatus() == ENTER_COORDINATES_SWAP_ERR) {
            System.out.println("Can't swap coordinates. Try again.");
        }
    }

}

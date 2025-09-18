package threeinarow.game;

import threeinarow.bonus.Bonus;
import threeinarow.bonus.BonusAccount;
import threeinarow.common.command.Command;
import threeinarow.matrix.realization.Figures;

public class BonusGame extends AbstractGame implements WithBonuses {

    private BonusAccount bonusAccount;
    private AbstractGame game;

    public BonusGame(BonusAccount bonusAccount) {
        this.bonusAccount = bonusAccount;
        this.game = new Game();
    }

    @Override
    public Bonus getTotalBonus() {
        return bonusAccount.getBonuses();
    }

    @Override
    public void showStepHistory() {
        game.showStepHistory();
    }

    @Override
    public Figures getFiguresAfterRound() {
        return game.getFiguresAfterRound();
    }

    @Override
    public void enterCoordinates() {
        game.enterCoordinates();
    }

    @Override
    public void executeRound() {
        game.executeRound();
        Figures figures = getFiguresAfterRound();
        Bonus bonus = bonusAccount.calculateBonuses(figures);
        bonusAccount.add(bonus);
    }

    @Override
    public int getEnterCoordinatesStatus() {
        return game.getEnterCoordinatesStatus();
    }

    @Override
    public int getExecuteRoundStatus() {
        return game.getExecuteRoundStatus();
    }
}

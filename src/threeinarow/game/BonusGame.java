package threeinarow.game;

import threeinarow.bonus.Bonus;
import threeinarow.bonus.BonusAccount;
import threeinarow.common.command.Command;
import threeinarow.matrix.realization.Figures;

public class BonusGame extends AbstractGame implements WithBonuses {

    private BonusAccount bonusAccount;
    private Game game;

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



}

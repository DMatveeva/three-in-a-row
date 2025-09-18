package threeinarow.bonus;

import threeinarow.game.BonusGame;
import threeinarow.matrix.realization.Figures;

public class BonusAccount extends AbstractBonusAccount {

    private final static BonusAccount INSTANCE = new BonusAccount();

    public static BonusAccount getInstance() {
        return INSTANCE;
    }

    private Bonus total = new Bonus(0);

    @Override
    public Bonus getBonuses() {
        return total;
    }

    @Override
    public Bonus calculateBonuses(Figures figures) {
        return new Bonus(figures.getCoordinates().size());
    }

    @Override
    public void add(Bonus bonus) {
        this.total = total.add(bonus);
    }

    @Override
    public void setStrategy(BonusStrategy strategy) {

    }
}

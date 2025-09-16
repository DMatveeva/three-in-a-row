package threeinarow.bonus;

import threeinarow.matrix.realization.Figures;

public abstract class BonusAccount {

    // команды
    public abstract Bonus getBonuses();

    public abstract Bonus calculateBonuses(Figures figures);

    // запросы

    // предусловие: bonus > zero
    public abstract void add(Bonus bonus);

    public abstract void setStrategy(BonusStrategy strategy);
}

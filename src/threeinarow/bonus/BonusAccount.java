package threeinarow.bonus;

public abstract class BonusAccount {

    // команды
    public abstract Bonus getBonuses();

    // запросы

    // предусловие: bonus > zero
    public abstract void add(Bonus bonus);

    public abstract void setStrategy(BonusStrategy strategy);
}

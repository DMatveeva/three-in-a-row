package threeinarow.game.realization;

/**
 *
 */
public abstract class AbstractCell {

    //values

    // создает
    public AbstractCell() {

    }

    //запросы

    public abstract boolean isEmpty();

    public abstract boolean equals();

    public abstract int hashcode();

    public abstract boolean isHit();

    public abstract String getValueForUI();

    // команды


}

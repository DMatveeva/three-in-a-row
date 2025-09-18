package threeinarow.bonus;

public class Bonus {

    private final int sum;

    public Bonus(int sum) {
        this.sum = sum;
    }

    public Bonus add(Bonus bonus) {
        return new Bonus(this.sum + bonus.sum);
    }


    @Override
    public String toString() {
        return String.valueOf(sum);
    }
}

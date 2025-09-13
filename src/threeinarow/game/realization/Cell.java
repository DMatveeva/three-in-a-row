package threeinarow.game.realization;


public final class Cell {

    private final Letter value;
    public boolean hit;

    public Cell(Letter letter) {
        this.value = letter;
    }

    public boolean isEmpty() {
        return value == Letter.O;
    }

    public boolean equals(Cell cell) {
        return value == cell.value;
    }

    public int hashcode() {
        return value.hashCode();
    }

    public boolean isHit() {
        return hit;
    }

    public String getValueForUI() {
        return value.name();
    }
}

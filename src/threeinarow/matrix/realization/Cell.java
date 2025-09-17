package threeinarow.matrix.realization;


import java.util.Objects;

public final class Cell {

    private final Letter value;
    public boolean hit;

    public Cell(Letter letter) {
        this.value = letter;
    }

    public boolean isEmpty() {
        return value == Letter.O;
    }

    public boolean equals(Cell other) {
        return this.value == other.value;
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

    @Override
    public String toString() {
        return value.getUiName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return value == cell.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

package threeinarow.matrix.realization;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс реализации
 */
public final class CartesianCoordinate {

    private final Coordinate x;
    private final Coordinate y;

    public CartesianCoordinate(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }

    private final static List<CartesianCoordinate> values = new ArrayList<>();

    static {
        for (Coordinate x: Coordinate.values()) {
            for (Coordinate y: Coordinate.values()) {
                values.add(new CartesianCoordinate(x, y));
            }
        }
    }

    public static List<CartesianCoordinate> values() {
        return List.copyOf(values);
    }

    public boolean isNeighbour(CartesianCoordinate other) {
        Coordinate thisX = this.x;
        Coordinate thisY = this.y;
        Coordinate otherX = other.x;
        Coordinate otherY = other.y;
        return (thisX == otherX && thisY.isNeighbour(otherY)) || (thisY == otherY && thisX.isNeighbour(otherX));
    }

    public static int getCount() {
        return getMaxWidth()^2;
    }
    public static int getMaxWidth() {
        return Coordinate.getMaxWidth();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianCoordinate that = (CartesianCoordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("%s%s", x.name(), y.asNum());
    }
}


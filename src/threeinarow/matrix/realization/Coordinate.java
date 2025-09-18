package threeinarow.matrix.realization;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public enum Coordinate implements Comparable<Coordinate> {
    a(0),
    b(1),
    c(2),
    d(3),
    e(4),
    f(5),
    g(6),
    h(7);

    private int num;
    private Coordinate(int num) {
        this.num = num;
    }

    private final static EnumMap<Coordinate, List<Coordinate>> neighbours = new EnumMap<>(Coordinate.class);
    static {
        neighbours.put(a, List.of(b));
        neighbours.put(b, List.of(a, c));
        neighbours.put(c, List.of(b, d));
        neighbours.put(d, List.of(c, e));
        neighbours.put(e, List.of(d, f));
        neighbours.put(f, List.of(e, g));
        neighbours.put(g, List.of(f, h));
        neighbours.put(h, List.of(g));
    }

    public static int getMaxWidth() {
        return Coordinate.values().length;
    }

    public static Coordinate fromNum(String num) {
        return Arrays.stream(Coordinate.values())
                .filter(v -> v.num == Integer.parseInt(num))
                .findFirst().get();
    }

    public boolean isNeighbour(Coordinate other) {
        List<Coordinate> thisNeighbours = neighbours.get(this);
        return thisNeighbours.contains(other);
    }

    public int asNum() {
        return num;
    }
}

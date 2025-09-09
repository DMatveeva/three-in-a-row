package threeinarow.graph;

public class Vertex<T> {

    private T value;
    private boolean hit;

    public Vertex(T value) {
        this.value = value;
    }

    public boolean isHit;

    public T getValue() {
        return value;
    }
}

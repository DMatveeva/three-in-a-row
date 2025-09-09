package threeinarow.graph;

import java.util.List;


/**
 * Класс реализации. Оборачивает список номеров узлов, которые составляют подграф с одинаковыми значениями.
 */
public class Subgraph {
    private List<Integer> verticeIndices;

    public void addIndex(int i) {
        verticeIndices.add(i);
    }
}

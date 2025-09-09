package threeinarow.graph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchGraph<T> {
    Vertex<T>[] vertices;
    int[][] adjacencyMatrix;

    SearchGraph(T[] tArray, int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;

        vertices = new Vertex[tArray.length];
        for(int i = 0; i < tArray.length; i++) {
            Vertex<T> vertex = new Vertex<>(tArray[i]);
            vertices[i] = vertex;
        }
    }

    public List<Subgraph> getSubgraphs() {

    }
}
//параметризация и массивы - почему не работает, надо подумать
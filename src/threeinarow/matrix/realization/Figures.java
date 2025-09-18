package threeinarow.matrix.realization;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс реализации, оборачивает список фигур
 */
public class Figures {

    private Set<Figure> figures;

    public Figures(Set<Figure> figures) {
        this.figures = Set.copyOf(figures);
    }

    public static Figures empty() {
        return new Figures(Set.of());
    }

    public boolean isEmpty() {
        return Figures.empty().equals(this);
    }

    public Set<CartesianCoordinate> getCoordinates() {
        return figures.stream()
                .flatMap(f -> f.getCoordinates().stream())
                .collect(Collectors.toSet());
    }

    public Figures union(Figures other) {
        Set<Figure> newFigures = new HashSet<>();
        newFigures.addAll(this.figures);
        newFigures.addAll(other.figures);
        return new Figures(newFigures);
    }

    public Figures superimpose(Figures other) {
        Set<Figure> thisFigures = new HashSet<>(this.figures);
        Set<Figure> otherFigures = new HashSet<>(other.figures);
        Set<Figure> newFigures = new HashSet<>();

        List<Figure> superimposedFigures = new ArrayList<>();

        //TODO!!!
        for (Figure f: thisFigures) {
            for (Figure o: otherFigures) {
                if(f.intersects(o)) {
                    Figure newFigure = f.superimpose(o);
                    newFigures.add(newFigure);
                    superimposedFigures.add(f);
                    superimposedFigures.add(o);
                }
            }
        }
        superimposedFigures.forEach(thisFigures::remove);
        superimposedFigures.forEach(otherFigures::remove);
        newFigures.addAll(thisFigures);
        newFigures.addAll(otherFigures);
        return new Figures(newFigures);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figures figures1 = (Figures) o;
        return Objects.equals(figures, figures1.figures);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(figures);
    }

    @Override
    public String toString() {
        return figures.stream()
                .map(Figure::toString)
                .sorted()
                .collect(Collectors.joining("\n"));
    }
}

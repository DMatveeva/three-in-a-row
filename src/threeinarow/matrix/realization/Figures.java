package threeinarow.matrix.realization;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс реализации, оборачивает список фигур
 */
public class Figures {

    private List<Figure> figures;

    public Figures(List<Figure> figures) {
        this.figures = List.copyOf(figures);
    }

    public static Figures empty() {
        return new Figures(List.of());
    }

    public Figures union(Figures other) {
        List<Figure> newFigures = new ArrayList<>();
        newFigures.addAll(this.figures);
        newFigures.addAll(other.figures);
        return new Figures(newFigures);
    }

    public Figures superimpose(Figures other) {
        List<Figure> thisFigures = this.figures;
        List<Figure> otherFigures = other.figures;
        return thisFigures.stream()
                .flatMap(f ->
                        otherFigures.stream()
                                .map(o -> o.superimpose(f)))
                .reduce(Figures.empty(), Figures::union);
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
                .collect(Collectors.joining("\n"));
    }
}

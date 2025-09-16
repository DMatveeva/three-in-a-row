package threeinarow.matrix.realization;

import java.util.List;

public enum Letter {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    O(" ");

    private final String uiName;

    Letter(String uiName) {
        this.uiName = uiName;
    }

    public String getUiName() {
        return uiName;
    }


    public static List<Letter> getNotEmpty() {
        return List.of(A, B, C, D, E);
    }
}

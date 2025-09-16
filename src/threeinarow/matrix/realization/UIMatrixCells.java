package threeinarow.matrix.realization;


import static threeinarow.matrix.realization.GameConstants.UI_CELL_DELIMETER;
import static threeinarow.matrix.realization.GameConstants.UI_INDENT;

public class UIMatrixCells {
    String[][] uiCells;

    public UIMatrixCells(String[][] uiCells) {
        this.uiCells = uiCells;
    }

    public String asString() {
        StringBuilder builder = new StringBuilder();
        builder.append(GameConstants.UI_HEADER_1);
        builder.append(GameConstants.UI_HEADER_2);
        for (int i = 0; i < uiCells.length; i++) {
            builder.append(getUiRow(i));
        }
        builder.append(GameConstants.UI_HEADER_2);
        return builder.toString();
    }

    private String getUiRow(int i) {
        String s = String.join(UI_CELL_DELIMETER, uiCells[i]);
        return String.join(UI_INDENT, String.valueOf(i + 1), "|", s, "|", "\n");
    }
}

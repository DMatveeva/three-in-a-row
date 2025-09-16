package threeinarow.matrix.realization;


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
        return builder.toString();
    }

    private String getUiRow(int i) {
        String s = String.join(" ", uiCells[i]);
        return String.join(" ", String.valueOf(i + 1), "|", s, "\n");
    }
}

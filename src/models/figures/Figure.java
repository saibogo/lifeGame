package models.figures;

import models.CellsType;
import models.Constants;

import java.util.ArrayList;
import java.util.List;

public class Figure {

    protected final List<List<CellsType>> figureArray;

    public Figure(long height, long width) {
        this.figureArray = new ArrayList<>();
        for (long i = 0; i < Math.max(height, 1); i++) {
            List<CellsType> tmpList = new ArrayList<>();
            for (long j = 0; j < Math.max(width, 1); j++) {
                tmpList.add(CellsType.EMPTY);
            }
            this.figureArray.add(tmpList);
        }
    }

    public void setCellLive(long row, long column) {
        try {
            this.figureArray.get((int)row).set((int) column, CellsType.LIVE);
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public long getHeight() {
        return figureArray.size();
    }

    public long getWidth() {
        return figureArray.get(0).size();
    }

    public List<List<CellsType>> getFigureArray() {
        return figureArray;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.whiteString);
        for(List<CellsType> lst: this.figureArray) {
            for(CellsType cell: lst) {
                builder.append(cell);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}

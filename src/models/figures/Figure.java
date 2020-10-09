package models.figures;

import models.CellsType;
import models.Constants;

import java.util.ArrayList;
import java.util.List;

public class Figure {

    private long height;
    private long width;
    private List<List<CellsType>> figureArray;

    public Figure(long height, long width) {
        this.height = height;
        this.width = width;
        this.figureArray = new ArrayList<>();
        for (long i = 0; i < this.height; i++) {
            List<CellsType> tmpList = new ArrayList<>();
            for (long j = 0; j < this.width; j++) {
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
        return height;
    }

    public long getWidth() {
        return width;
    }

    public List<List<CellsType>> getFigureArray() {
        return figureArray;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.whiteString);
        for (long i = 0; i < this.figureArray.size(); i++) {
            for (long j = 0; j < this.figureArray.get(0).size(); j++) {
                builder.append(this.figureArray.get((int)i).get((int)j));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}

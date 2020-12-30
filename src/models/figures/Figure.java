package models.figures;

import models.CellsType;
import models.Constants;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

import java.util.ArrayList;
import java.util.List;

public class Figure {

    protected final List<List<CellsType>> figureArray;
    protected final String figureName;
    protected final FigureTypes figureTypes;
    protected final FigureGroups figureGroups;

    public Figure(String figureName, long height, long width, FigureTypes figureTypes, FigureGroups figureGroups) {
        this.figureName = figureName;
        this.figureTypes = figureTypes;
        this.figureGroups = figureGroups;
        this.figureArray = new ArrayList<>();
        for (long i = 0; i < Math.max(height, 1); i++) {
            List<CellsType> tmpList = new ArrayList<>();
            for (long j = 0; j < Math.max(width, 1); j++) {
                tmpList.add(CellsType.EMPTY);
            }
            this.figureArray.add(tmpList);
        }
    }


    public String getFigureName() {
        return figureName;
    }

    public final void setCellLive(long row, long column) {
        try {
            this.figureArray.get((int)row).set((int) column, CellsType.LIVE);
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public final long getHeight() {
        return figureArray.size();
    }

    public final long getWidth() {
        return figureArray.get(0).size();
    }

    public final List<List<CellsType>> getFigureArray() {
        return figureArray;
    }

    public final FigureTypes getFigureTypes() {
        return this.figureTypes;
    }

    public final FigureGroups getFigureGroups() {
        return this.figureGroups;
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

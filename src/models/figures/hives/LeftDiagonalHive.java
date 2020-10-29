package models.figures.hives;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public final class LeftDiagonalHive extends Figure {
    private static LeftDiagonalHive instance;

    private LeftDiagonalHive() {
        super("Леводиагональный Улей", 3, 3, FigureTypes.STABLE, FigureGroups.HIVES);
        this.setCellLive(0, 0);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(1, 2);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);

    }

    public static Figure getInstance() {
        if (LeftDiagonalHive.instance == null) {
            LeftDiagonalHive.instance = new LeftDiagonalHive();
        }
        return LeftDiagonalHive.instance;
    }
}

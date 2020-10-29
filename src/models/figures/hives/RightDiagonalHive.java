package models.figures.hives;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public final class RightDiagonalHive extends Figure {
    private static RightDiagonalHive instance;

    private RightDiagonalHive() {
        super("Праводиагональный Улей", 3, 3, FigureTypes.STABLE, FigureGroups.HIVES);
        this.setCellLive(0, 1);
        this.setCellLive(0, 2);
        this.setCellLive(1, 0);
        this.setCellLive(1, 2);
        this.setCellLive(2, 0);
        this.setCellLive(2, 1);

    }

    public static Figure getInstance() {
        if (RightDiagonalHive.instance == null) {
            RightDiagonalHive.instance = new RightDiagonalHive();
        }
        return RightDiagonalHive.instance;
    }
}

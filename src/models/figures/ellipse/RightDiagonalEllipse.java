package models.figures.ellipse;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public class RightDiagonalEllipse extends Figure {
    private static RightDiagonalEllipse instance;

    private RightDiagonalEllipse() {
        super("праводиагональный эллипс", 3, 3, FigureTypes.STABLE, FigureGroups.ELLIPSE);
        this.setCellLive(0, 1);
        this.setCellLive(0, 2);
        this.setCellLive(1, 0);
        this.setCellLive(1, 2);
        this.setCellLive(2, 0);
        this.setCellLive(2, 1);

    }

    public static Figure getInstance() {
        if (RightDiagonalEllipse.instance == null) {
            RightDiagonalEllipse.instance = new RightDiagonalEllipse();
        }
        return RightDiagonalEllipse.instance;
    }
}

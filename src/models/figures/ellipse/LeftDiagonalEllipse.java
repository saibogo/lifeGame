package models.figures.ellipse;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public class LeftDiagonalEllipse extends Figure {
    private static LeftDiagonalEllipse instance;

    private LeftDiagonalEllipse() {
        super("Леводиагональный эллипс", 3, 3, FigureTypes.STABLE, FigureGroups.ELLIPSE);
        this.setCellLive(0, 0);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(1, 2);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);

    }

    public static Figure getInstance() {
        if (LeftDiagonalEllipse.instance == null) {
            LeftDiagonalEllipse.instance = new LeftDiagonalEllipse();
        }
        return LeftDiagonalEllipse.instance;
    }
}

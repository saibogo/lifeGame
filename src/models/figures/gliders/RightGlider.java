package models.figures.gliders;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public final class RightGlider extends Figure {

    private static RightGlider instance;

    private RightGlider() {
        super("Правонаправленный Глайдер", 3, 3, FigureTypes.RUN, FigureGroups.GLIDERS);
        this.setCellLive(0, 1);
        this.setCellLive(1, 2);
        this.setCellLive(2, 0);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);

    }

    public static Figure getInstance() {
        if (RightGlider.instance == null) {
            RightGlider.instance = new RightGlider();
        }
        return RightGlider.instance;
    }
}

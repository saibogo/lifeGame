package models.figures.gliders;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public final class LeftGlider extends Figure {

    private static LeftGlider instance;

    private LeftGlider() {
        super("Левонаправленный Глайдер", 3, 3, FigureTypes.RUN, FigureGroups.GLIDERS);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(2, 0);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);

    }

    public static Figure getInstance() {
        if (LeftGlider.instance == null) {
            LeftGlider.instance = new LeftGlider();
        }
        return LeftGlider.instance;
    }
}

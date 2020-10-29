package models.figures.gliders;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public final class UpGlider extends Figure {
    private static UpGlider instance;

    private UpGlider() {
        super("Верхненаправленный Глайдер", 3, 3, FigureTypes.RUN, FigureGroups.GLIDERS);
        this.setCellLive(0, 2);
        this.setCellLive(1, 2);
        this.setCellLive(2, 2);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);

    }

    public static Figure getInstance() {
        if (UpGlider.instance == null) {
            UpGlider.instance = new UpGlider();
        }
        return UpGlider.instance;
    }
}

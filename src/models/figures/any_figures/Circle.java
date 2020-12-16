package models.figures.any_figures;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public final class Circle extends Figure {
    private static Circle instance;

    private Circle() {
        super("Круг",4 ,4, FigureTypes.STABLE, FigureGroups.NONE);
        for (int i = 1; i < 3; i++){
            this.setCellLive(i, 0);
            this.setCellLive(0, i);
            this.setCellLive(3, i);
            this.setCellLive(i, 3);
        }
    }

    public static Figure getInstance() {
        if (Circle.instance == null) {
            Circle.instance = new Circle();
        }
        return Circle.instance;
    }
}

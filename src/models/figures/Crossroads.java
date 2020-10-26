package models.figures;

import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public class Crossroads extends Figure{
    private static Crossroads instance;

    private Crossroads() {
        super("Перекресток",9 ,9, FigureTypes.PULSE, FigureGroups.NONE);
        for (int i = 0; i < 3; i++) {
            this.setCellLive(i, 4);
            this.setCellLive(4, i);
            this.setCellLive(8 - i, 4);
            this.setCellLive(4, 8 - i);
        }

    }

    public static Figure getInstance() {
        if (Crossroads.instance == null) {
            Crossroads.instance = new Crossroads();
        }
        return Crossroads.instance;
    }
}

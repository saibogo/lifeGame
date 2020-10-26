package models.figures;

import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public class Turnstile extends Figure {
    private static Turnstile instance;

    private Turnstile() {
        super("Турникет",4 ,4, FigureTypes.PULSE, FigureGroups.SEMAPHORE);
        this.setCellLive(0, 0);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(3, 3);
        this.setCellLive(3, 2);
        this.setCellLive(2, 3);
    }

    public static Figure getInstance() {
        if (Turnstile.instance == null) {
            Turnstile.instance = new Turnstile();
        }
        return Turnstile.instance;
    }
}

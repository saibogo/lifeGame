package models.figures;

import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public class VerticalSemaphore extends Figure {

    private static VerticalSemaphore instance;

    public VerticalSemaphore() {
        super("Вертикальный Семафор", 3, 1, FigureTypes.PULSE, FigureGroups.SEMAPHORE);
        this.setCellLive(0, 0);
        this.setCellLive(1, 0);
        this.setCellLive(2, 0);
    }

    public static Figure getInstance() {
        if (VerticalSemaphore.instance == null) {
            VerticalSemaphore.instance = new VerticalSemaphore();
        }
        return VerticalSemaphore.instance;
    }
}
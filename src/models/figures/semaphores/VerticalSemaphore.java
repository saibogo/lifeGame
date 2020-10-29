package models.figures.semaphores;

import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

public final class VerticalSemaphore extends Figure {

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
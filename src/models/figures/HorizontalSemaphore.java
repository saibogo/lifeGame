package models.figures;

public class HorizontalSemaphore extends Figure {
    public HorizontalSemaphore() {
        super(1, 3);
        this.setCellLive(0, 0);
        this.setCellLive(0, 1);
        this.setCellLive(0, 2);
    }
}

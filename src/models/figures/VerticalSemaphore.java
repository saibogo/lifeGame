package models.figures;

public class VerticalSemaphore extends Figure {
    public VerticalSemaphore() {
        super(3, 1);
        this.setCellLive(0, 0);
        this.setCellLive(1, 0);
        this.setCellLive(2, 0);
    }
}
package models.figures;

public class LeftGlider extends Figure {
    public LeftGlider() {
        super(3, 3);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(2, 0);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);

    }
}

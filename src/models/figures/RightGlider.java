package models.figures;

public class RightGlider extends Figure {
    public RightGlider() {
        super(3, 3);
        this.setCellLive(0, 1);
        this.setCellLive(1, 2);
        this.setCellLive(2, 0);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);

    }
}

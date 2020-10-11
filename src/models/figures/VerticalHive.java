package models.figures;

public class VerticalHive extends Figure {

    public VerticalHive() {
        super(4, 3);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(1, 2);
        this.setCellLive(2, 0);
        this.setCellLive(2, 2);
        this.setCellLive(3, 1);
    }
}

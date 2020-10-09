package models.figures;

public class Square2_2 extends Figure {
    public Square2_2() {
        super(2, 2);
        this.setCellLive(0, 0);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(1, 1);
    }
}

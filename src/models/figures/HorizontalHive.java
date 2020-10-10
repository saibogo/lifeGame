package models.figures;

public class HorizontalHive  extends Figure{
    public HorizontalHive() {
        super(3, 4);
        this.setCellLive(0, 1);
        this.setCellLive(0, 2);
        this.setCellLive(1, 0);
        this.setCellLive(1, 3);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);
    }
}

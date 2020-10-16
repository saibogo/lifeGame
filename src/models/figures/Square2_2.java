package models.figures;

public class Square2_2 extends Figure {

    private static Square2_2 instance;

    public Square2_2() {
        super(2, 2);
        this.setCellLive(0, 0);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(1, 1);
    }

    public static Figure getInstance() {
        if (Square2_2.instance == null) {
            Square2_2.instance = new Square2_2();
        }
        return Square2_2.instance;
    }
}

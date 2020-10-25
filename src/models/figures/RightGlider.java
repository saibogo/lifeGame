package models.figures;

public class RightGlider extends Figure {

    private static RightGlider instance;

    public RightGlider() {
        super("Правонаправленный Глайдер", 3, 3);
        this.setCellLive(0, 1);
        this.setCellLive(1, 2);
        this.setCellLive(2, 0);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);

    }

    public static Figure getInstance() {
        if (RightGlider.instance == null) {
            RightGlider.instance = new RightGlider();
        }
        return RightGlider.instance;
    }
}

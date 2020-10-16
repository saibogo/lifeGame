package models.figures;

public class LeftGlider extends Figure {

    private static LeftGlider instance;

    private LeftGlider() {
        super("Glider To Left", 3, 3);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(2, 0);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);

    }

    public static Figure getInstance() {
        if (LeftGlider.instance == null) {
            LeftGlider.instance = new LeftGlider();
        }
        return LeftGlider.instance;
    }
}

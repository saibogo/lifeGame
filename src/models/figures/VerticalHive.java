package models.figures;

public class VerticalHive extends Figure {

    private static VerticalHive instance;

    public VerticalHive() {
        super("Vertical Hive", 4, 3);
        this.setCellLive(0, 1);
        this.setCellLive(1, 0);
        this.setCellLive(1, 2);
        this.setCellLive(2, 0);
        this.setCellLive(2, 2);
        this.setCellLive(3, 1);
    }

    public static Figure getInstance() {
        if (VerticalHive.instance == null) {
            VerticalHive.instance = new VerticalHive();
        }
        return VerticalHive.instance;
    }
}

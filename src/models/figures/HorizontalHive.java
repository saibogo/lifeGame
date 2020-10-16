package models.figures;

public class HorizontalHive  extends Figure{

    private static HorizontalHive instance;

    private HorizontalHive() {
        super("Horizontal Hive",3 ,4);
        this.setCellLive(0, 1);
        this.setCellLive(0, 2);
        this.setCellLive(1, 0);
        this.setCellLive(1, 3);
        this.setCellLive(2, 1);
        this.setCellLive(2, 2);
    }

    public static Figure getInstance() {
        if (HorizontalHive.instance == null) {
            HorizontalHive.instance = new HorizontalHive();
        }
        return HorizontalHive.instance;
    }
}

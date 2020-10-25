package models.figures;

public class HorizontalSemaphore extends Figure {

    private static HorizontalSemaphore instance;

    private HorizontalSemaphore() {
        super("Горизонтальный Семафор", 1, 3);
        this.setCellLive(0, 0);
        this.setCellLive(0, 1);
        this.setCellLive(0, 2);
    }

    public static Figure getInstance() {
        if (HorizontalSemaphore.instance == null) {
            HorizontalSemaphore.instance = new HorizontalSemaphore();
        }
        return HorizontalSemaphore.instance;
    }
}

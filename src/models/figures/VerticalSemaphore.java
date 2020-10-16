package models.figures;

public class VerticalSemaphore extends Figure {

    private static VerticalSemaphore instance;

    public VerticalSemaphore() {
        super(3, 1);
        this.setCellLive(0, 0);
        this.setCellLive(1, 0);
        this.setCellLive(2, 0);
    }

    public static Figure getInstance() {
        if (VerticalSemaphore.instance == null) {
            VerticalSemaphore.instance = new VerticalSemaphore();
        }
        return VerticalSemaphore.instance;
    }
}
import controllers.BoardController;
import models.Board;
import models.Constants;
import models.figures.*;
import models.gui.GameCanvas;
import models.gui.MainFrame;


public class Main {
    public static void main(String[] args) throws InterruptedException {


        Constants constants = (new Constants.Builder())
                .setMinimalHeight(3)
                .setMinimalWidth(3)
                .setSleepInterval(700)
                .setSizeCell(20)
                .build();

        Board board = new Board(8, 10, constants);
        Figure hive = HorizontalHive.getInstance();
        Figure semaphore = HorizontalSemaphore.getInstance();
        MainFrame frame = new MainFrame(new GameCanvas(board));
        BoardController controller = new BoardController(board);
        controller.insert(hive, 0, 0);
        controller.insert(semaphore, 1, 4);

        for (int iteration = 0; iteration < 200; iteration++) {
            Thread.sleep(constants.getSleepInterval());
            controller.iteration();
            frame.repaintBoard();
            frame.setTitle("Поколение №" + iteration);
        }

    }
}

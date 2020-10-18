import controllers.BoardController;
import models.Board;
import models.Constants;
import models.figures.*;
import views.gui.GameCanvas;
import views.gui.InputSizeFrame;
import views.gui.MainFrame;

import java.awt.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {


        Constants constants = (new Constants.Builder())
                .setMinimalHeight(3)
                .setMinimalWidth(3)
                .setSleepInterval(700)
                .setSizeCell(20)
                .build();

        Dimension boardDimension = new Dimension((int)constants.getMinimalWidth(), (int)constants.getMinimalHeight());

        InputSizeFrame sizeFrame = new InputSizeFrame(boardDimension);
        while (sizeFrame.isFrameIsRunning()) {
            Thread.sleep(50);
        }

        Board board = new Board(boardDimension.height, boardDimension.width, constants);
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
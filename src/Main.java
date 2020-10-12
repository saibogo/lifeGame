import controllers.BorderRules;
import controllers.InsertFigureToBoardController;
import controllers.Rules;
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
        Figure semaphore = new VerticalSemaphore();
        InsertFigureToBoardController.insert(board, semaphore, 1, 4);
        Figure hive = new VerticalHive();
        InsertFigureToBoardController.insert(board, hive, 0, 0);
        MainFrame frame = new MainFrame(new GameCanvas(board));

        for (int iteration = 0; iteration < 200; iteration++) {
            Thread.sleep(constants.getSleepInterval());
            Rules.iteration(board);
            BorderRules.addBorderIfNeed(board);
            BorderRules.removeBordersIfNeed(board);
            frame.repaintBoard();
            frame.setTitle("Поколение №" + iteration);
        }

    }
}

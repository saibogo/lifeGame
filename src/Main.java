import java.util.Calendar;

import controllers.BorderRules;
import controllers.InsertFigureToBoardController;
import controllers.Rules;
import models.Board;
import models.Constants;
import models.figures.Figure;
import models.figures.HorizontalSemaphore;
import models.figures.Square2_2;
import models.figures.VerticalSemaphore;


public class Main {
    public static void main(String[] args) throws InterruptedException {


        Constants constants = (new Constants.Builder())
                .setMinimalHeight(3)
                .setMinimalWidth(3)
                .setSleepInterval(700)
                .build();

        long timeStart, timeStop;


        Figure square1 = new Square2_2();
        Figure horizontalSemaphore = new HorizontalSemaphore();
        Figure verticalSemaphore = new VerticalSemaphore();
        System.out.println(verticalSemaphore);
        Board board = new Board(5, 5, constants);
        InsertFigureToBoardController.insert(board, square1, 2, 2);
        InsertFigureToBoardController.insert(board, horizontalSemaphore, 0, 0);
        InsertFigureToBoardController.insert(board, verticalSemaphore, 2, 0);

        System.out.println(board);

        for (long iteration = 0; iteration < 400; iteration++) {
            timeStart = Calendar.getInstance().getTimeInMillis();
            Rules.iteration(board);
            BorderRules.addBorderIfNeed(board);
            BorderRules.removeBordersIfNeed(board);
            System.out.println(board);
            timeStop = Calendar.getInstance().getTimeInMillis();

            Thread.sleep(Math.max(0, constants.getSleepInterval() - (timeStop - timeStart)));
        }
    }
}

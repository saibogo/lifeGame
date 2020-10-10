import java.util.Calendar;

import controllers.BorderRules;
import controllers.InsertFigureToBoardController;
import controllers.Rules;
import models.Board;
import models.Constants;
import models.figures.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {


        Constants constants = (new Constants.Builder())
                .setMinimalHeight(3)
                .setMinimalWidth(3)
                .setSleepInterval(700)
                .build();

        long timeStart, timeStop;

        Board board = new Board(4, 6, constants);
        Figure hive = new HorizontalHive();
        Figure semaphore = new VerticalSemaphore();
        InsertFigureToBoardController.insert(board, hive, 1, 1);
        InsertFigureToBoardController.insert(board, semaphore, 0, 5);

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

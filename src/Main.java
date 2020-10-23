import controllers.BoardController;
import models.Board;
import models.Constants;
import views.gui.BoardCreatorFrame;
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

        InputSizeFrame sizeFrame = new InputSizeFrame(boardDimension, constants);
        while (sizeFrame.isFrameIsRunning()) {
            Thread.sleep(50);
        }

        Board board = new Board(boardDimension, constants);
        BoardCreatorFrame boardCreatorFrame = new BoardCreatorFrame(board);
        boardCreatorFrame.dispose();

        BoardController boardController = new BoardController(board);
        MainFrame mainFrame = new MainFrame(new GameCanvas(board));
        long generation = 0;
        while (true) {
            mainFrame.setTitle("Generation " + generation);
            mainFrame.repaintBoard();
            Thread.sleep(constants.getSleepInterval());
            boardController.iteration();
            generation++;

        }

    }
}
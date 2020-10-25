import controllers.BoardController;
import models.Board;
import models.Constants;
import views.gui.BoardCreatorFrame;
import views.gui.GameCanvas;
import views.gui.InputSizeFrame;
import views.gui.MainFrame;

import javax.swing.*;
import java.awt.*;

import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) throws InterruptedException {



        Constants constants = (new Constants.Builder())
                .setMinimalHeight(10)
                .setMinimalWidth(10)
                .setSleepInterval(700)
                .setSizeCell(20)
                .build();

        Dimension boardDimension = new Dimension((int) constants.getMinimalWidth(), (int) constants.getMinimalHeight());

        InputSizeFrame sizeFrame = new InputSizeFrame(boardDimension, constants);
        while (sizeFrame.isFrameIsRunning()) {
            Thread.sleep(50);
        }

        Board board = new Board(boardDimension, constants);

        while (true) {
            BoardCreatorFrame boardCreatorFrame = new BoardCreatorFrame(board);

            boardCreatorFrame.setVisible(false);
            boardCreatorFrame.dispose();

            BoardController boardController = new BoardController(board);
            MainFrame mainFrame = new MainFrame(new GameCanvas(board));
            long generation = 0;
            while (!mainFrame.isSpacePressed()) {
                mainFrame.setTitle("Поколение " + generation);
                mainFrame.repaintBoard();
                Thread.sleep(constants.getSleepInterval());
                boardController.iteration();
                generation++;

            }
            int yesNoDialog = JOptionPane.showConfirmDialog(mainFrame,
                    "Хотите продолжить эволюцию или модифицировать колонию?",
                    "Прервано", JOptionPane.YES_NO_OPTION);

            mainFrame.setVisible(false);
            mainFrame.dispose();
            if (yesNoDialog == JOptionPane.NO_OPTION) {
                exit(0);
            }
        }
    }
}
package views.gui;

import any.FigureSelector;
import models.Board;

import javax.swing.*;
import java.awt.*;

public class BoardCreatorFrame extends JFrame {

    private CreateCanvasGui createCanvasGui;
    private boolean gameDone = false;

    public BoardCreatorFrame(Board board) throws InterruptedException {
        super("Начальное положение клеток");
        FigureSelector figureSelector = new FigureSelector();
        this.createCanvasGui = new CreateCanvasGui(board, figureSelector);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu selectMenu = new JMenu("Select");
        menuBar.add(selectMenu);
        selectMenu.setVisible(true);


        for (int i = 0; i < figureSelector.getFiguresCount(); i++) {
            JMenuItem figureItem = new JMenuItem(figureSelector.getAllFiguresNames().get(i));
            int finalI = i;
            figureItem.addActionListener(actionEvent -> figureSelector.setNumberSelectedFigure(finalI));
            selectMenu.add(figureItem);
            figureItem.setVisible(true);
        }

        JMenu actionMenu = new JMenu("Action");
        menuBar.add(actionMenu);
        actionMenu.setVisible(true);

        JMenuItem runItem = new JMenuItem("Run");
        actionMenu.add(runItem);
        runItem.setVisible(true);

        runItem.addActionListener(e -> {
                setVisible(false);
                gameDone = true;
                dispose();

        });


        this.setJMenuBar(menuBar);
        menuBar.setVisible(true);


        this.add(this.createCanvasGui);
        this.createCanvasGui.setVisible(true);
        this.pack();
        this.setVisible(true);
        this.repaint();

        while (!gameDone) {
            Thread.sleep(100);
            if (this.createCanvasGui.isReadyToUpdate()) {
                this.repaintBoard();
            }
        }
    }

    public void repaintBoard() {
        this.remove(this.createCanvasGui);
        this.add(this.createCanvasGui);
        this.createCanvasGui.setVisible(true);
        this.pack();
        this.setVisible(true);
        this.repaint();

    }

    public boolean isGameDone() {
        return gameDone;
    }

    @Override
    public void dispose() {
        super.dispose();
        setVisible(false);
    }
}

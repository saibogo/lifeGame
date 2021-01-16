package views.gui;

import any.FigureSelector;
import models.Board;
import models.figures.support.Localisation;

import javax.swing.*;
import java.awt.*;

import static java.lang.System.exit;

public class BoardCreatorFrame extends JFrame {

    private CreateCanvasGui createCanvasGui;
    private boolean gameDone = false;

    public BoardCreatorFrame(Board board) throws InterruptedException {
        super(Localisation.startPositionCells());
        FigureSelector figureSelector = new FigureSelector();
        this.createCanvasGui = new CreateCanvasGui(board, figureSelector);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        SelectFiguresMenu selectMenu = new SelectFiguresMenu(figureSelector);
        menuBar.add(selectMenu);
        selectMenu.setVisible(true);



        JMenu actionMenu = new JMenu(Localisation.ActionsMenuTitle());
        menuBar.add(actionMenu);
        actionMenu.setVisible(true);

        JMenuItem runItem = new JMenuItem(Localisation.RunSubMenuTitle());
        actionMenu.add(runItem);
        runItem.setVisible(true);

        runItem.addActionListener(e -> {
                setVisible(false);
                gameDone = true;
                dispose();

        });

        JMenuItem rotateToLeft = new JMenuItem(Localisation.RotateBoardSubMenuTitle());
        actionMenu.add(rotateToLeft);
        rotateToLeft.setVisible(true);

        rotateToLeft.addActionListener(e -> {
            board.rotateToLeft();
            repaintBoard();
        });

        JMenuItem rotateToRight = new JMenuItem(Localisation.RotateReverseBoardSubMenuTitle());
        actionMenu.add(rotateToRight);
        rotateToRight.setVisible(true);

        rotateToRight.addActionListener(e -> {
            board.rotateToRight();
            repaintBoard();
        });

        JMenuItem exitItem = new JMenuItem(Localisation.ExitSubMenuTitle());
        actionMenu.add(exitItem);
        exitItem.setVisible(true);

        exitItem.addActionListener(actionEvent -> exit(0));

        JMenu helpMenu = new JMenu(Localisation.HelpSubMenuTitle());
        menuBar.add(helpMenu);
        helpMenu.setVisible(true);

        JMenuItem rulesItem = new JMenuItem(Localisation.RulesSubMenuTitle());
        helpMenu.add(rulesItem);
        rulesItem.setVisible(true);

        rulesItem.addActionListener(actionEvent -> showRules()
        );

        JMenuItem interfaceItem = new JMenuItem(Localisation.InterfaceSubMenuTitle());
        helpMenu.add(interfaceItem);
        interfaceItem.setVisible(true);
        interfaceItem.addActionListener(e -> {
            showInterfaceOption();
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

    public void setGameDone(boolean gameDone) {
        this.gameDone = gameDone;
    }

    @Override
    public void dispose() {
        setVisible(false);
        super.dispose();
    }

    private void showRules(){
        JOptionPane.showMessageDialog(this, Localisation.RulesMessageText());
    }

    private void showInterfaceOption() {
        JOptionPane.showMessageDialog(this, Localisation.InterfaceMessageText());
    }
}

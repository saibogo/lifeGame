package views.gui;

import any.FigureSelector;
import models.Board;

import javax.swing.*;
import java.awt.*;

import static java.lang.System.exit;

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

        JMenuItem exitItem = new JMenuItem("Exit");
        actionMenu.add(exitItem);
        exitItem.setVisible(true);

        exitItem.addActionListener(actionEvent -> exit(0));

        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        helpMenu.setVisible(true);

        JMenuItem rulesItem = new JMenuItem("Rules");
        helpMenu.add(rulesItem);
        rulesItem.setVisible(true);

        rulesItem.addActionListener(actionEvent -> showRules()
        );

        JMenuItem interfaceItem = new JMenuItem("Interface");
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
        JOptionPane.showMessageDialog(this, "Новая клетка рождается," +
                " если у нее ровно три соседа.\nЕсли у клетки меньше двух соседей, или больше трех  - клетка умирает");
    }

    private void showInterfaceOption() {
        JOptionPane.showMessageDialog(this, "Создать/удалить клетку - левая кнопка мышки\n" +
                "Select - выбрать фигуру из каталога для вставки\n" +
                "Вставить готовую фигуру - правая кнопка мышки\n" +
                "Action -> Run  - запустить эволюцию колонии клеток" +
                "SPACE - прервать эволюцию колонии");
    }
}

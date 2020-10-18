package views.gui;

import models.Board;
import models.CellsType;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private Board board;

    public GameCanvas(Board board) {

        this.board = board;

        this.setPreferredSize(new Dimension((int) (this.board.getConstants().getSizeCell() * this.board.getWidth()),
                (int) this.board.getHeight() * this.board.getConstants().getSizeCell()));
    }


    @Override
    public void paintComponent(Graphics g) {
        int size = this.board.getConstants().getSizeCell();

        this.setPreferredSize(new Dimension((int) (size * this.board.getWidth()),
                (int) this.board.getHeight() * size));

        g.setColor(Color.BLACK);

        for (int j = 0; j < this.board.getWidth(); j++) {
            g.drawLine(j * size,
                    0,
                    j * this.board.getConstants().getSizeCell(),
                    (int) (this.board.getHeight() * size));
        }

        for (int i = 0; i < this.board.getHeight(); i++) {
            g.drawLine(0,
                    i * size,
                    (int) this.board.getWidth() * size,
                    i * size);
        }

        g.setColor(Color.RED);

        for (int i = 0; i < this.board.getHeight(); i++) {
            for (int j = 0; j < this.board.getWidth(); j++) {
                if (this.board.getCell(i, j).equals(CellsType.LIVE)) {
                    int x = j * size + 1;
                    int y = i * size + 1;
                    g.fillOval(x, y, Math.max( size - 2, 1),  Math.max(size - 2, 1));
                }
            }
        }
    }

    @Override
    public void update(Graphics g) {
        this.removeAll();
        this.paintComponent(g);
    }
}

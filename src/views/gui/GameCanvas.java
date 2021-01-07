package views.gui;

import any.Config;
import models.Board;
import models.CellsType;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private final Board board;
    private final Config config;

    public GameCanvas(Board board) {

        this.board = board;
        this.config = Config.getInstance();

        this.setPreferredSize(new Dimension((int) (this.board.getConstants().getSizeCell() * this.board.getWidth()),
                (int) this.board.getHeight() * this.board.getConstants().getSizeCell()));
    }


    @Override
    public void paintComponent(Graphics g) {
        int size = this.board.getConstants().getSizeCell();
        int height = (int) this.board.getHeight();
        int width = (int) this.board.getWidth();

        this.setPreferredSize(new Dimension(size * width, height * size));

        g.setColor(this.config.getBackgroundColor());
        g.fillRect(0, 0, size * (width + 1),
                (height + 1) * size);

        g.setColor(this.config.getLineColor());

        for (int j = 0; j <= width; j++) {
            g.drawLine(j * size,
                    0,
                    j * this.board.getConstants().getSizeCell(),
                    (height + 1) * size);
        }

        for (int i = 0; i <= height; i++) {
            g.drawLine(0,
                    i * size,
                    (width + 1) * size,
                    i * size);
        }


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!this.board.getCell(i, j).equals(CellsType.EMPTY))
                {
                    int x = j * size + 1;
                    int y = i * size + 1;

                    if (this.board.getCell(i, j).equals(CellsType.LIVE)) {
                        g.setColor(this.config.getLiveCellColor());
                    } else if (this.board.getCell(i, j).equals(CellsType.BORN)) {
                        g.setColor(this.config.getBornCellColor());
                    } else if (this.board.getCell(i, j).equals(CellsType.DEAD)) {
                        g.setColor(this.config.getDeadCellColor());
                    }

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

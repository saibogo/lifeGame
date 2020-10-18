package views.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private GameCanvas canvas;

    public MainFrame(GameCanvas canvas) throws HeadlessException {
        super("Игра ЖИЗНЬ");
        this.canvas = canvas;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(this.canvas);
        this.canvas.setVisible(true);
        this.pack();
        this.setVisible(true);
        this.repaint();
    }

    public void repaintBoard() {
        this.remove(this.canvas);
        this.add(this.canvas);
        this.canvas.setVisible(true);
        this.pack();
        this.setVisible(true);
        this.repaint();

    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }
}

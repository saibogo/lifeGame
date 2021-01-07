package views.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame {

    private GameCanvas canvas;
    private boolean spacePressed = false;

    public MainFrame(GameCanvas canvas) throws HeadlessException {
        super("Игра ЖИЗНЬ");
        this.canvas = canvas;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(this.canvas);
        this.canvas.setVisible(true);
        this.pack();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyChar() == ' ') {
                    spacePressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
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

    public boolean isSpacePressed() {
        return spacePressed;
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

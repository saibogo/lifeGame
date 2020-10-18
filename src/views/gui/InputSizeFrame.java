package views.gui;

import any.DigitFilter;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputSizeFrame extends JFrame {

    private Dimension dimension;
    private boolean frameIsRunning;

    public InputSizeFrame(Dimension dimension) throws HeadlessException {
        super("Размеры игрового поля");

        this.frameIsRunning = true;

        this.dimension = dimension;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4, 1));

        JPanel labelPanel = new JPanel();

        JLabel label = new JLabel("Задайте размеры поля");
        labelPanel.add(label);
        label.setVisible(true);

        this.add(labelPanel);
        labelPanel.setVisible(true);

        JPanel panelHeight = new JPanel();
        JLabel labelHeight = new JLabel("Клеток в высоту: ");
        panelHeight.add(labelHeight);
        labelHeight.setVisible(true);

        JTextField fieldHeight = new JTextField(10);
        PlainDocument doc = (PlainDocument) fieldHeight.getDocument();
        fieldHeight.setText("" + dimension.height);
        doc.setDocumentFilter(new DigitFilter());
        panelHeight.add(fieldHeight);
        fieldHeight.setVisible(true);


        this.add(panelHeight);
        panelHeight.setVisible(true);

        JPanel panelWidth = new JPanel();
        JLabel labelWidth = new JLabel("Клеток в ширину: ");
        panelWidth.add(labelWidth);
        labelWidth.setVisible(true);

        JTextField fieldWidth = new JTextField(10);
        PlainDocument doc1 = (PlainDocument) fieldWidth.getDocument();
        doc1.setDocumentFilter(new DigitFilter());
        fieldWidth.setText("" + dimension.width);
        panelWidth.add(fieldWidth);
        fieldWidth.setVisible(true);

        this.add(panelWidth);
        panelWidth.setVisible(true);


        JButton createDimensionButton = new JButton("Применить");
        createDimensionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dimension.height = Integer.parseInt(fieldHeight.getText());
                dimension.width = Integer.parseInt(fieldWidth.getText());
                frameIsRunning = false;
                dispose();
            }
        });

        this.add(createDimensionButton);
        createDimensionButton.setVisible(true);

        this.pack();
        this.setVisible(true);

    }

    public boolean isFrameIsRunning() {
        return this.frameIsRunning;
    }
}

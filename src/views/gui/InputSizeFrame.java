package views.gui;

import any.Config;
import any.DigitFilter;
import models.Constants;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class InputSizeFrame extends JFrame {

    private boolean frameIsRunning;

    public InputSizeFrame(Dimension dimension, Constants constants) throws HeadlessException {
        super("Размеры игрового поля");

        this.frameIsRunning = true;

        DigitFilter digitFilter = new DigitFilter();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(9, 2));

        JLabel label = new JLabel("Задайте размеры поля");
        this.add(label);
        label.setVisible(true);

        this.add(new JLabel());

        JLabel labelHeight = new JLabel("Клеток в высоту: ");
        this.add(labelHeight);
        labelHeight.setVisible(true);


        JTextField fieldHeight = new JTextField(10);
        PlainDocument doc = (PlainDocument) fieldHeight.getDocument();
        fieldHeight.setText("" + dimension.height);
        doc.setDocumentFilter(digitFilter);
        this.add(fieldHeight);
        fieldHeight.setVisible(true);

        JLabel minimalHeightLabel = new JLabel("Минимальная высота поля:");
        this.add(minimalHeightLabel);
        minimalHeightLabel.setVisible(true);

        JTextField minimalHeightField = new JTextField(10);
        PlainDocument doc2 = (PlainDocument) minimalHeightField.getDocument();
        minimalHeightField.setText("" + constants.getMinimalHeight());
        doc2.setDocumentFilter(digitFilter);
        this.add(minimalHeightField);
        minimalHeightField.setVisible(true);


        JLabel labelWidth = new JLabel("Клеток в ширину: ");
        this.add(labelWidth);
        labelWidth.setVisible(true);

        JTextField fieldWidth = new JTextField(10);
        PlainDocument doc1 = (PlainDocument) fieldWidth.getDocument();
        doc1.setDocumentFilter(digitFilter);
        fieldWidth.setText("" + dimension.width);
        this.add(fieldWidth);
        fieldWidth.setVisible(true);

        JLabel minimalWidthLabel = new JLabel("Минимальная ширина игрового поля");
        this.add(minimalWidthLabel);
        minimalWidthLabel.setVisible(true);

        JTextField minimalWidthField = new JTextField(10);
        PlainDocument doc3 = (PlainDocument) minimalWidthField.getDocument();
        doc3.setDocumentFilter(digitFilter);
        minimalWidthField.setText("" + constants.getMinimalWidth());
        this.add(minimalWidthField);
        minimalWidthField.setVisible(true);

        JLabel sizeCellLabel = new JLabel("Размер ячейки в пикселях");
        this.add(sizeCellLabel);
        sizeCellLabel.setVisible(true);

        JTextField sizeCellField = new JTextField(10);
        PlainDocument doc4 = (PlainDocument) sizeCellField.getDocument();
        doc4.setDocumentFilter(digitFilter);
        sizeCellField.setText("" + constants.getSizeCell());
        this.add(sizeCellField);
        sizeCellField.setVisible(true);

        JLabel timeSleepLabel = new JLabel("Пауза между поколениями, мс");
        this.add(timeSleepLabel);
        timeSleepLabel.setVisible(true);

        JTextField timeSleepField = new JTextField(10);
        PlainDocument doc5 = (PlainDocument) timeSleepField.getDocument();
        doc5.setDocumentFilter(digitFilter);
        timeSleepField.setText("" + constants.getSleepInterval());
        this.add(timeSleepField);
        timeSleepField.setVisible(true);


        JLabel allGenerationRadioButton = new JLabel("Показывать все стадии клетки");
        this.add(allGenerationRadioButton);
        allGenerationRadioButton.setVisible(true);

        JCheckBox allGenerationCheckBox = new JCheckBox();
        this.add(allGenerationCheckBox);
        allGenerationCheckBox.setVisible(true);


        JButton createDimensionButton = new JButton("Применить");
        createDimensionButton.addActionListener(e -> {
            constants.setMinimalHeight(Long.parseLong(minimalHeightField.getText()));
            constants.setMinimalWidth(Long.parseLong(minimalWidthField.getText()));
            constants.setSizeCell(Integer.parseInt(sizeCellField.getText()));
            constants.setSleepInterval(Long.parseLong(timeSleepField.getText()));
            Config.getInstance().setViewAllStepGeneration(allGenerationCheckBox.isSelected());
            dimension.height = Math.max(Integer.parseInt(fieldHeight.getText()), (int)constants.getMinimalHeight());
            dimension.width = Math.max(Integer.parseInt(fieldWidth.getText()), (int)constants.getMinimalWidth());
            frameIsRunning = false;
            dispose();
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

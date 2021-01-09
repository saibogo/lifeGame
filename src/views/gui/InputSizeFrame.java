package views.gui;

import any.Config;
import any.DigitFilter;
import models.Constants;
import models.figures.support.Language;
import models.figures.support.Localisation;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputSizeFrame extends JFrame {

    private boolean frameIsRunning;

    public InputSizeFrame(Dimension dimension, Constants constants) throws HeadlessException {
        super(Localisation.SetBoardParametersText());

        this.frameIsRunning = true;

        DigitFilter digitFilter = new DigitFilter();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(10, 2));

        JLabel labelLang = new JLabel(Localisation.LanguageLabelText());
        this.add(labelLang);
        labelLang.setVisible(true);

        ButtonGroup langButtonGroup = new ButtonGroup();
        JPanel langButtonPanel = new JPanel();
        this.add(langButtonPanel);
        langButtonPanel.setVisible(true);

        JRadioButton ruButton = new JRadioButton("RU", true);
        langButtonGroup.add(ruButton);
        langButtonPanel.add(ruButton);


        JRadioButton engButton = new JRadioButton("ENG", false);
        langButtonGroup.add(engButton);
        langButtonPanel.add(engButton);


        JLabel label = new JLabel(Localisation.SetSizeBoardText());
        this.add(label);
        label.setVisible(true);

        this.add(new JLabel());

        JLabel labelHeight = new JLabel(Localisation.CellsInHeightText());
        this.add(labelHeight);
        labelHeight.setVisible(true);


        JTextField fieldHeight = new JTextField(10);
        PlainDocument doc = (PlainDocument) fieldHeight.getDocument();
        fieldHeight.setText("" + dimension.height);
        doc.setDocumentFilter(digitFilter);
        this.add(fieldHeight);
        fieldHeight.setVisible(true);

        JLabel minimalHeightLabel = new JLabel(Localisation.MinimalHeightText());
        this.add(minimalHeightLabel);
        minimalHeightLabel.setVisible(true);

        JTextField minimalHeightField = new JTextField(10);
        PlainDocument doc2 = (PlainDocument) minimalHeightField.getDocument();
        minimalHeightField.setText("" + constants.getMinimalHeight());
        doc2.setDocumentFilter(digitFilter);
        this.add(minimalHeightField);
        minimalHeightField.setVisible(true);


        JLabel labelWidth = new JLabel(Localisation.CellsInWidthText());
        this.add(labelWidth);
        labelWidth.setVisible(true);

        JTextField fieldWidth = new JTextField(10);
        PlainDocument doc1 = (PlainDocument) fieldWidth.getDocument();
        doc1.setDocumentFilter(digitFilter);
        fieldWidth.setText("" + dimension.width);
        this.add(fieldWidth);
        fieldWidth.setVisible(true);

        JLabel minimalWidthLabel = new JLabel(Localisation.MinimalWidthText());
        this.add(minimalWidthLabel);
        minimalWidthLabel.setVisible(true);

        JTextField minimalWidthField = new JTextField(10);
        PlainDocument doc3 = (PlainDocument) minimalWidthField.getDocument();
        doc3.setDocumentFilter(digitFilter);
        minimalWidthField.setText("" + constants.getMinimalWidth());
        this.add(minimalWidthField);
        minimalWidthField.setVisible(true);

        JLabel sizeCellLabel = new JLabel(Localisation.CellSizeText());
        this.add(sizeCellLabel);
        sizeCellLabel.setVisible(true);

        JTextField sizeCellField = new JTextField(10);
        PlainDocument doc4 = (PlainDocument) sizeCellField.getDocument();
        doc4.setDocumentFilter(digitFilter);
        sizeCellField.setText("" + constants.getSizeCell());
        this.add(sizeCellField);
        sizeCellField.setVisible(true);

        JLabel timeSleepLabel = new JLabel(Localisation.GenerationPauseText());
        this.add(timeSleepLabel);
        timeSleepLabel.setVisible(true);

        JTextField timeSleepField = new JTextField(10);
        PlainDocument doc5 = (PlainDocument) timeSleepField.getDocument();
        doc5.setDocumentFilter(digitFilter);
        timeSleepField.setText("" + constants.getSleepInterval());
        this.add(timeSleepField);
        timeSleepField.setVisible(true);


        JLabel allGenerationRadioButton = new JLabel(Localisation.AllStageCellText());
        this.add(allGenerationRadioButton);
        allGenerationRadioButton.setVisible(true);

        JCheckBox allGenerationCheckBox = new JCheckBox();
        this.add(allGenerationCheckBox);
        allGenerationCheckBox.setVisible(true);


        JButton createDimensionButton = new JButton(Localisation.ApplyText());
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

        ruButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.getInstance().setLanguage(Language.RU);
                labelLang.setText(Localisation.LanguageLabelText());
                label.setText(Localisation.SetSizeBoardText());
                setTitle(Localisation.SetBoardParametersText());
                labelHeight.setText(Localisation.CellsInHeightText());
                minimalHeightLabel.setText(Localisation.MinimalHeightText());
                labelWidth.setText(Localisation.CellsInWidthText());
                minimalHeightLabel.setText(Localisation.MinimalWidthText());
                sizeCellLabel.setText(Localisation.CellSizeText());
                timeSleepLabel.setText(Localisation.GenerationPauseText());
                allGenerationRadioButton.setText(Localisation.AllStageCellText());
                createDimensionButton.setText(Localisation.ApplyText());
            }
        });

        engButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.getInstance().setLanguage(Language.ENG);
                labelLang.setText(Localisation.LanguageLabelText());
                label.setText(Localisation.SetSizeBoardText());
                setTitle(Localisation.SetBoardParametersText());
                labelHeight.setText(Localisation.CellsInHeightText());
                minimalHeightLabel.setText(Localisation.MinimalHeightText());
                labelWidth.setText(Localisation.CellsInWidthText());
                minimalHeightLabel.setText(Localisation.MinimalWidthText());
                sizeCellLabel.setText(Localisation.CellSizeText());
                timeSleepLabel.setText(Localisation.GenerationPauseText());
                allGenerationRadioButton.setText(Localisation.AllStageCellText());
                createDimensionButton.setText(Localisation.ApplyText());
            }
        });

        this.pack();
        this.setVisible(true);


    }


    public boolean isFrameIsRunning() {
        return this.frameIsRunning;
    }
}

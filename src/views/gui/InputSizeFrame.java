package views.gui;

import any.Config;
import any.DigitFilter;
import models.Constants;
import models.figures.support.Language;
import models.figures.support.Localisation;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class InputSizeFrame extends JFrame {

    private boolean frameIsRunning;
    private final JLabel labelLang;
    private final JLabel mainLabel;
    private final JLabel labelHeight;
    private final JLabel minimalHeightLabel;
    private final JLabel labelWidth;
    private final JLabel minimalWidthLabel;
    private final JLabel sizeCellLabel;
    private final JLabel timeSleepLabel;
    private final JLabel allGenerationRadioButton;
    private final JButton createDimensionButton;

    public InputSizeFrame(Dimension dimension, Constants constants) throws HeadlessException {
        super(Localisation.SetBoardParametersText());

        this.frameIsRunning = true;

        DigitFilter digitFilter = new DigitFilter();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(10, 2));

        this.labelLang = new JLabel();
        this.add(this.labelLang);
        this.labelLang.setVisible(true);

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


        this.mainLabel = new JLabel();
        this.add(this.mainLabel);
        this.mainLabel.setVisible(true);

        this.add(new JLabel());

        this.labelHeight = new JLabel();
        this.add(this.labelHeight);
        this.labelHeight.setVisible(true);


        JTextField fieldHeight = new JTextField(10);
        PlainDocument doc = (PlainDocument) fieldHeight.getDocument();
        fieldHeight.setText("" + dimension.height);
        doc.setDocumentFilter(digitFilter);
        this.add(fieldHeight);
        fieldHeight.setVisible(true);

        this.minimalHeightLabel = new JLabel();
        this.add(this.minimalHeightLabel);
        this.minimalHeightLabel.setVisible(true);

        JTextField minimalHeightField = new JTextField(10);
        PlainDocument doc2 = (PlainDocument) minimalHeightField.getDocument();
        minimalHeightField.setText("" + constants.getMinimalHeight());
        doc2.setDocumentFilter(digitFilter);
        this.add(minimalHeightField);
        minimalHeightField.setVisible(true);


        this.labelWidth = new JLabel();
        this.add(this.labelWidth);
        this.labelWidth.setVisible(true);

        JTextField fieldWidth = new JTextField(10);
        PlainDocument doc1 = (PlainDocument) fieldWidth.getDocument();
        doc1.setDocumentFilter(digitFilter);
        fieldWidth.setText("" + dimension.width);
        this.add(fieldWidth);
        fieldWidth.setVisible(true);

        this.minimalWidthLabel = new JLabel();
        this.add(this.minimalWidthLabel);
        this.minimalWidthLabel.setVisible(true);

        JTextField minimalWidthField = new JTextField(10);
        PlainDocument doc3 = (PlainDocument) minimalWidthField.getDocument();
        doc3.setDocumentFilter(digitFilter);
        minimalWidthField.setText("" + constants.getMinimalWidth());
        this.add(minimalWidthField);
        minimalWidthField.setVisible(true);

        this.sizeCellLabel = new JLabel();
        this.add(this.sizeCellLabel);
        this.sizeCellLabel.setVisible(true);

        JTextField sizeCellField = new JTextField(10);
        PlainDocument doc4 = (PlainDocument) sizeCellField.getDocument();
        doc4.setDocumentFilter(digitFilter);
        sizeCellField.setText("" + constants.getSizeCell());
        this.add(sizeCellField);
        sizeCellField.setVisible(true);

        this.timeSleepLabel = new JLabel();
        this.add(this.timeSleepLabel);
        this.timeSleepLabel.setVisible(true);

        JTextField timeSleepField = new JTextField(10);
        PlainDocument doc5 = (PlainDocument) timeSleepField.getDocument();
        doc5.setDocumentFilter(digitFilter);
        timeSleepField.setText("" + constants.getSleepInterval());
        this.add(timeSleepField);
        timeSleepField.setVisible(true);


        this.allGenerationRadioButton = new JLabel();
        this.add(this.allGenerationRadioButton);
        this.allGenerationRadioButton.setVisible(true);

        JCheckBox allGenerationCheckBox = new JCheckBox();
        this.add(allGenerationCheckBox);
        allGenerationCheckBox.setVisible(true);


        this.createDimensionButton = new JButton();
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

        this.add(this.createDimensionButton);
        this.createDimensionButton.setVisible(true);

        ruButton.addActionListener(e -> {
            Config.getInstance().setLanguage(Language.RU);
            reSetText();
        });

        engButton.addActionListener(e -> {
            Config.getInstance().setLanguage(Language.ENG);
            reSetText();
        });

        this.reSetText();

        this.pack();
        this.setVisible(true);

    }

    private void reSetText() {
        this.setTitle(Localisation.SetBoardParametersText());
        this.labelLang.setText(Localisation.LanguageLabelText());
        this.mainLabel.setText(Localisation.SetSizeBoardText());
        this.labelHeight.setText(Localisation.CellsInHeightText());
        this.minimalHeightLabel.setText(Localisation.MinimalHeightText());
        this.labelWidth.setText(Localisation.CellsInWidthText());
        this.minimalWidthLabel.setText(Localisation.MinimalWidthText());
        this.sizeCellLabel.setText(Localisation.CellSizeText());
        this.timeSleepLabel.setText(Localisation.GenerationPauseText());
        this.allGenerationRadioButton.setText(Localisation.AllStageCellText());
        this.createDimensionButton.setText(Localisation.ApplyText());
    }

    public boolean isFrameIsRunning() {
        return this.frameIsRunning;
    }
}

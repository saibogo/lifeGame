package views.gui;

import any.FigureSelector;
import models.figures.Figure;
import models.figures.support.FigureTypes;

import javax.swing.*;

public class SelectFiguresMenu extends JMenu {
    private FigureSelector figureSelector;

    public SelectFiguresMenu(FigureSelector figureSelector) {
        super("Select");
        this.figureSelector = figureSelector;

        JMenu runFigures = new JMenu("" + FigureTypes.RUN);
        runFigures.setVisible(true);
        this.add(runFigures);

        JMenu stableFigures = new JMenu("" + FigureTypes.STABLE);
        stableFigures.setVisible(true);
        this.add(stableFigures);


        JMenu pulseFigures = new JMenu("" + FigureTypes.PULSE);
        pulseFigures.setVisible(true);
        this.add(pulseFigures);

        for (int i = 0; i < figureSelector.getFiguresCount(); i++) {
            JMenuItem figureItem = new JMenuItem(figureSelector.getAllFiguresNames().get(i));
            int finalI = i;
            figureItem.addActionListener(actionEvent -> figureSelector.setNumberSelectedFigure(finalI));
            Figure tmpFigure = figureSelector.getFigureNumber(i);

            if (tmpFigure.getFigureTypes().equals(FigureTypes.RUN)) {
                runFigures.add(figureItem);
            }
            if (tmpFigure.getFigureTypes().equals(FigureTypes.PULSE)) {
                pulseFigures.add(figureItem);
            }
            if (tmpFigure.getFigureTypes().equals(FigureTypes.STABLE)) {
                stableFigures.add(figureItem);
            }
            figureItem.setVisible(true);
        }

    }
}

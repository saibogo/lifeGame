package views.gui;

import any.FigureSelector;
import models.figures.Figure;
import models.figures.support.FigureGroups;
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

        JMenu hivesGroup = new JMenu("" + FigureGroups.HIVES);
        hivesGroup.setVisible(true);
        stableFigures.add(hivesGroup);

        JMenu semaphoreGroup = new JMenu("" + FigureGroups.SEMAPHORE);
        semaphoreGroup.setVisible(true);
        pulseFigures.add(semaphoreGroup);

        JMenu glidersGroup = new JMenu("" + FigureGroups.GLIDERS);
        glidersGroup.setVisible(true);
        runFigures.add(glidersGroup);

        for (int i = 0; i < figureSelector.getFiguresCount(); i++) {
            JMenuItem figureItem = new JMenuItem(figureSelector.getAllFiguresNames().get(i));
            int finalI = i;
            figureItem.addActionListener(actionEvent -> figureSelector.setNumberSelectedFigure(finalI));
            Figure tmpFigure = figureSelector.getFigureNumber(i);

            if (tmpFigure.getFigureGroups().equals(FigureGroups.NONE)) {

                if (tmpFigure.getFigureTypes().equals(FigureTypes.RUN)) {
                    runFigures.add(figureItem);
                }
                if (tmpFigure.getFigureTypes().equals(FigureTypes.PULSE)) {
                    pulseFigures.add(figureItem);
                }
                if (tmpFigure.getFigureTypes().equals(FigureTypes.STABLE)) {
                    stableFigures.add(figureItem);
                }
            } else {
                if (tmpFigure.getFigureGroups().equals(FigureGroups.HIVES)) {
                    hivesGroup.add(figureItem);
                }
                if (tmpFigure.getFigureGroups().equals(FigureGroups.SEMAPHORE)) {
                    semaphoreGroup.add(figureItem);
                }
                if (tmpFigure.getFigureGroups().equals(FigureGroups.GLIDERS)) {
                    glidersGroup.add(figureItem);
                }
            }
            figureItem.setVisible(true);
        }

    }
}

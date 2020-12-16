package views.gui;

import any.FigureSelector;
import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;

import javax.swing.*;
import java.security.KeyException;
import java.util.HashMap;
import java.util.Map;

public class SelectFiguresMenu extends JMenu {

    private Map<FigureTypes, JMenu> noneGroupsFigures = new HashMap<>();
    private Map<FigureGroups, JMenu> figuresInGroups = new HashMap<>();

    private FigureSelector figureSelector;

    public SelectFiguresMenu(FigureSelector figureSelector) {
        super("Select");
        this.figureSelector = figureSelector;

        JMenu runFigures = new JMenu("" + FigureTypes.RUN);
        runFigures.setVisible(true);
        this.add(runFigures);
        noneGroupsFigures.put(FigureTypes.RUN, runFigures);

        JMenu stableFigures = new JMenu("" + FigureTypes.STABLE);
        stableFigures.setVisible(true);
        this.add(stableFigures);
        noneGroupsFigures.put(FigureTypes.STABLE, stableFigures);


        JMenu pulseFigures = new JMenu("" + FigureTypes.PULSE);
        pulseFigures.setVisible(true);
        this.add(pulseFigures);
        noneGroupsFigures.put(FigureTypes.PULSE, pulseFigures);

        JMenu hivesGroup = new JMenu("" + FigureGroups.HIVES);
        hivesGroup.setVisible(true);
        stableFigures.add(hivesGroup);
        figuresInGroups.put(FigureGroups.HIVES, hivesGroup);

        JMenu semaphoreGroup = new JMenu("" + FigureGroups.SEMAPHORE);
        semaphoreGroup.setVisible(true);
        pulseFigures.add(semaphoreGroup);
        figuresInGroups.put(FigureGroups.SEMAPHORE, semaphoreGroup);

        JMenu glidersGroup = new JMenu("" + FigureGroups.GLIDERS);
        glidersGroup.setVisible(true);
        runFigures.add(glidersGroup);
        figuresInGroups.put(FigureGroups.GLIDERS, glidersGroup);

        JMenu ellipseGroup = new JMenu("" + FigureGroups.ELLIPSE);
        ellipseGroup.setVisible(true);
        stableFigures.add(ellipseGroup);
        figuresInGroups.put(FigureGroups.ELLIPSE, ellipseGroup);

        for (int i = 0; i < figureSelector.getFiguresCount(); i++) {
            JMenuItem figureItem = new JMenuItem(figureSelector.getAllFiguresNames().get(i));
            int finalI = i;
            figureItem.addActionListener(actionEvent -> figureSelector.setNumberSelectedFigure(finalI));
            Figure tmpFigure = figureSelector.getFigureNumber(i);
/*
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
                if (tmpFigure.getFigureGroups().equals(FigureGroups.ELLIPSE)) {
                    ellipseGroup.add(figureItem);
                }
            }*/

            if (tmpFigure.getFigureGroups().equals(FigureGroups.NONE)) {
                noneGroupsFigures.get(tmpFigure.getFigureTypes()).add(figureItem);
                } else {
                figuresInGroups.get(tmpFigure.getFigureGroups()).add(figureItem);
            }

            figureItem.setVisible(true);
        }

    }


}



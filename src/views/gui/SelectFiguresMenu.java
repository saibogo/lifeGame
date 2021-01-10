package views.gui;

import any.FigureSelector;
import models.figures.Figure;
import models.figures.support.FigureGroups;
import models.figures.support.FigureTypes;
import models.figures.support.Localisation;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class SelectFiguresMenu extends JMenu {

    public SelectFiguresMenu(FigureSelector figureSelector) {
        super(Localisation.SelectSubMenuTitle());

        JMenu runFigures = new JMenu("" + FigureTypes.RUN);
        runFigures.setVisible(true);
        this.add(runFigures);
        Map<FigureTypes, JMenu> noneGroupsFigures = new HashMap<>();
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
        Map<FigureGroups, JMenu> figuresInGroups = new HashMap<>();
        figuresInGroups.put(FigureGroups.HIVES, hivesGroup);

        JMenu semaphoreGroup = new JMenu("" + FigureGroups.SEMAPHORE);
        semaphoreGroup.setVisible(true);
        pulseFigures.add(semaphoreGroup);
        figuresInGroups.put(FigureGroups.SEMAPHORE, semaphoreGroup);

        JMenu glidersGroup = new JMenu("" + FigureGroups.GLIDERS);
        glidersGroup.setVisible(true);
        runFigures.add(glidersGroup);
        figuresInGroups.put(FigureGroups.GLIDERS, glidersGroup);

        JMenu sectorsGroup = new JMenu("" + FigureGroups.SECTORS);
        sectorsGroup.setVisible(true);
        stableFigures.add(sectorsGroup);
        figuresInGroups.put(FigureGroups.SECTORS, sectorsGroup);

        JMenu pulsedHivesGroup = new JMenu("" + FigureGroups.PULSED_HIVES);
        pulsedHivesGroup.setVisible(true);
        pulseFigures.add(pulsedHivesGroup);
        figuresInGroups.put(FigureGroups.PULSED_HIVES, pulsedHivesGroup);


        for (int i = 0; i < figureSelector.getFiguresCount(); i++) {
            JMenuItem figureItem = new JMenuItem(figureSelector.getAllFiguresNames().get(i));
            int finalI = i;
            figureItem.addActionListener(actionEvent -> figureSelector.setNumberSelectedFigure(finalI));
            Figure tmpFigure = figureSelector.getFigureNumber(i);

            if (tmpFigure.getFigureGroups().equals(FigureGroups.NONE)) {
                noneGroupsFigures.get(tmpFigure.getFigureTypes()).add(figureItem);
                } else {
                figuresInGroups.get(tmpFigure.getFigureGroups()).add(figureItem);
            }

            figureItem.setVisible(true);
        }

    }


}



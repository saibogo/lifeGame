package any;

import models.figures.*;
import models.figures.any_figures.Circle;
import models.figures.any_figures.Pulsar;
import models.figures.any_figures.Square2_2;
import models.figures.ellipse.LeftDiagonalEllipse;
import models.figures.ellipse.RightDiagonalEllipse;
import models.figures.gliders.LeftGlider;
import models.figures.gliders.RightGlider;
import models.figures.gliders.UpGlider;
import models.figures.hives.HorizontalHive;
import models.figures.hives.LeftDiagonalHive;
import models.figures.hives.RightDiagonalHive;
import models.figures.hives.VerticalHive;
import models.figures.semaphores.Crossroads;
import models.figures.semaphores.HorizontalSemaphore;
import models.figures.semaphores.Turnstile;
import models.figures.semaphores.VerticalSemaphore;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FigureSelector {
    private final List<Figure> allFiguresList;
    private int numberSelectedFigure;

    public FigureSelector() {

        this.allFiguresList = new ArrayList<>();



        this.allFiguresList.add(HorizontalHive.getInstance());
        this.allFiguresList.add(HorizontalSemaphore.getInstance());
        this.allFiguresList.add(LeftGlider.getInstance());
        this.allFiguresList.add(RightGlider.getInstance());
        this.allFiguresList.add(Square2_2.getInstance());
        this.allFiguresList.add(VerticalHive.getInstance());
        this.allFiguresList.add(VerticalSemaphore.getInstance());
        this.allFiguresList.add(Pulsar.getInstance());
        this.allFiguresList.add(Crossroads.getInstance());
        this.allFiguresList.add(Turnstile.getInstance());
        this.allFiguresList.add(Circle.getInstance());
        this.allFiguresList.add(RightDiagonalHive.getInstance());
        this.allFiguresList.add(LeftDiagonalHive.getInstance());
        this.allFiguresList.add(UpGlider.getInstance());
        this.allFiguresList.add(RightDiagonalEllipse.getInstance());
        this.allFiguresList.add(LeftDiagonalEllipse.getInstance());

        this.numberSelectedFigure = 0;
    }

    public List<String> getAllFiguresNames() {
        List<String> result = new ArrayList<>();
        for (Figure figure: this.allFiguresList) {
            result.add(figure.getFigureName());
        }
        return result;
    }

    public int getFiguresCount() {
        return this.allFiguresList.size();
    }

    public int getNumberSelectedFigure() {
        return this.numberSelectedFigure;
    }

    public Figure getSelectedFigure() {
        return this.allFiguresList.get(this.numberSelectedFigure);
    }

    public void setNumberSelectedFigure(int numberSelectedFigure) {
        this.numberSelectedFigure = numberSelectedFigure;
    }

    public Figure getFigureNumber(int num) {
        return this.allFiguresList.get(num);
    }

}

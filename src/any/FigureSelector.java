package any;

import models.figures.*;

import java.util.ArrayList;
import java.util.List;

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

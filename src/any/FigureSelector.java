package any;

import models.figures.*;
import models.figures.any_figures.Pulsar;
import models.figures.ellipse.LeftDiagonalEllipse;
import models.figures.ellipse.RightDiagonalEllipse;
import models.figures.hives.HorizontalHive;
import models.figures.hives.LeftDiagonalHive;
import models.figures.hives.RightDiagonalHive;
import models.figures.hives.VerticalHive;
import models.figures.support.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FigureSelector {
    private final List<Figure> allFiguresList;
    private int numberSelectedFigure;

    public FigureSelector() {

        this.allFiguresList = new ArrayList<>();

        try {
            List<Figure> figureList =  XMLReader.convertXMLToFiguresList();
            System.out.println("Всего загружено фигур " + figureList.size());
            for (Figure figure: figureList) {
                System.out.println("Получена фигура " + figure.getFigureName());
                this.allFiguresList.add(figure);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        this.allFiguresList.add(HorizontalHive.getInstance());
        this.allFiguresList.add(VerticalHive.getInstance());
        this.allFiguresList.add(Pulsar.getInstance());
        this.allFiguresList.add(RightDiagonalHive.getInstance());
        this.allFiguresList.add(LeftDiagonalHive.getInstance());
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

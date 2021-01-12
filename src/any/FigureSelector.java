package any;

import models.figures.*;
import models.figures.any_figures.Pulsar;
import models.figures.support.Localisation;
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
            System.out.println(Localisation.AllFiguresLoadedString() + figureList.size());
            for (Figure figure: figureList) {
                System.out.println(Localisation.GetFigureString() + figure.getFigureName());
                this.allFiguresList.add(figure);
            }
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        this.allFiguresList.add(Pulsar.getInstance());

        this.numberSelectedFigure = 0;
    }

    public List<String> getAllFiguresNames() {
        List<String> result = new ArrayList<>();
        for (Figure figure: this.allFiguresList) {
            result.add(figure.getFigureName() + " (" + figure.getHeight() + "x" + figure.getWidth() + ")");
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

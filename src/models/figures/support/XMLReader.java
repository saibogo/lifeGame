package models.figures.support;

import models.CellsType;
import models.figures.Figure;
import models.figures.ellipse.LeftDiagonalEllipse;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLReader {

    public static List<Map<String, String>> readFigures() throws ParserConfigurationException, IOException, SAXException {
        List<Map<String, String>> result = new ArrayList<>();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse("figures.xml");

        Node root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nodeList = root.getChildNodes();
        List<Node> figuresList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if(nodeList.item(i).getNodeName().equals("figure")) {
                figuresList.add(nodeList.item(i));
            }
        }
        System.out.println("Найдено " + figuresList.size() + " предполагаемых фигур.");
        for (Node node : figuresList) {
            System.out.println(node.getNodeName());
            NodeList figureParameters = node.getChildNodes();
            Map<String, String> parametersMap = new HashMap<>();
            for (int i = 0; i < figureParameters.getLength(); i++) {
               if (figureParameters.item(i).getNodeType() != Node.TEXT_NODE) {
                  parametersMap.put(figureParameters.item(i).getNodeName().trim(),
                          figureParameters.item(i).getTextContent().trim());
               }
            }
            for (String key: parametersMap.keySet()) {
                System.out.println(key + " -> " + parametersMap.get(key));
            }
            System.out.println("Найдено " + parametersMap.size() + " параметров");
            result.add(parametersMap);
        }
        System.out.println("Найдено " + result.size() + "кандидатов в фигуры");
        return result;
    }

    public static Figure convertXMLToFigure(Map<String, String> parameters) {
        long width = Long.parseLong(parameters.get("width"));
        long height = Long.parseLong(parameters.get("height"));
        String name = parameters.get("name");

        FigureTypes figureType;
        switch (parameters.get("type")) {
            case "PULSE" :
                figureType = FigureTypes.PULSE;
                break;
            case "RUN" :
                figureType = FigureTypes.RUN;
                break;
            default:
                figureType = FigureTypes.STABLE;
                break;
        }

        FigureGroups figureGroups;
        switch (parameters.get("group")) {
            case "SEMAPHORE" :
                figureGroups = FigureGroups.SEMAPHORE;
                break;
            case "GLIDERS" :
                figureGroups = FigureGroups.GLIDERS;
                break;
            case "HIVES" :
                figureGroups = FigureGroups.HIVES;
                break;
            case "ELLIPSE" :
                figureGroups = FigureGroups.ELLIPSE;
                break;
            default:
                figureGroups = FigureGroups.NONE;
                break;
        }

        Figure result = new Figure(name, height, width, figureType, figureGroups);
        List<CellsType> tmp = new ArrayList<>();
        for (Character character: parameters.get("view").toCharArray()){
            if (character.equals('#')) {
                tmp.add(CellsType.LIVE);
            } else if (character.equals('_')) {
                tmp.add(CellsType.EMPTY);
            }
        }

        if (height * width == tmp.size()) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (tmp.get((int)(i * height + j)).equals(CellsType.LIVE)) {
                        result.setCellLive(i, j);
                    }
                }
            }
        }

        return result;
    }

    public static List<Figure> convertXMLToFiguresList() throws IOException, SAXException, ParserConfigurationException {

        List<Figure> result = new ArrayList<>();
        for (Map<String, String> map: readFigures()){
            Figure newFigure = convertXMLToFigure(map);
            result.add(newFigure);
        }
        return result;
    }

}

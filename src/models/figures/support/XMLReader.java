package models.figures.support;

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
        
        return LeftDiagonalEllipse.getInstance();
    }

    public static void convertXMLToFiguresList() throws IOException, SAXException, ParserConfigurationException {
        for (Map<String, String> map: readFigures()){
            Figure newFigure = convertXMLToFigure(map);
        }
    }

}

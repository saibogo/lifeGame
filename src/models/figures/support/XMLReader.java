package models.figures.support;

import any.Config;
import models.CellsType;
import models.Constants;
import models.figures.Figure;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class XMLReader {

    public static List<Map<String, String>> readFigures(String filename) throws ParserConfigurationException,
            IOException, SAXException {
        List<Map<String, String>> result = new ArrayList<>();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(filename);

        Node root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nodeList = root.getChildNodes();
        List<Node> figuresList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("figure")) {
                figuresList.add(nodeList.item(i));
            }
        }
        System.out.println(Localisation.FoundString() + figuresList.size() + Localisation.AllegedFiguresString());
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
            for (String key : parametersMap.keySet()) {
                System.out.println(key + " -> " + parametersMap.get(key));
            }
            System.out.println(Localisation.FoundString() + parametersMap.size() + Localisation.ParametersString());
            result.add(parametersMap);
        }
        System.out.println(Localisation.FoundString() + result.size() + Localisation.AllegedFiguresString());
        return result;
    }

    public static Figure convertXMLToFigure(Map<String, String> parameters) {
        long width = Long.parseLong(parameters.get(Constants.widthString));
        long height = Long.parseLong(parameters.get(Constants.heightString));
        String name = (Config.getInstance().getLanguage() == Language.RU) ?
                parameters.get(Constants.nameString) : parameters.get(Constants.nameStringEng);
        if (name == null) {
            name = "";
        }


        FigureTypes figureType = switch (parameters.get(Constants.typeString)) {
            case Constants.pulseTypeString -> FigureTypes.PULSE;
            case Constants.runTypeString -> FigureTypes.RUN;
            default -> FigureTypes.STABLE;
        };


        FigureGroups figureGroups = switch (parameters.get(Constants.groupString)) {
            case Constants.semaphoreGroupString -> FigureGroups.SEMAPHORE;
            case Constants.glidersGroupString -> FigureGroups.GLIDERS;
            case Constants.hivesGroupString -> FigureGroups.HIVES;
            case Constants.sectorsGroupString -> FigureGroups.SECTORS;
            case Constants.pulsedHivesGroup -> FigureGroups.PULSED_HIVES;
            case Constants.bargesGroup -> FigureGroups.BARGES;
            default -> FigureGroups.NONE;
        };

        Figure result = new Figure(name, height, width, figureType, figureGroups);
        List<CellsType> tmp = new ArrayList<>();
        for (Character character : parameters.get(Constants.viewString).toCharArray()) {
            if (character.equals(Constants.liveCellChar)) {
                tmp.add(CellsType.LIVE);
            } else if (character.equals(Constants.emptyCellChar)) {
                tmp.add(CellsType.EMPTY);
            }
        }

        if (height * width == tmp.size()) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (tmp.get((int) (i * width + j)).equals(CellsType.LIVE)) {
                        result.setCellLive(i, j);
                    }
                }
            }
        }

        return result;
    }

    public static List<Figure> convertXMLToFiguresList() throws IOException, SAXException,
            ParserConfigurationException {

        List<Figure> result = new ArrayList<>();
        String figuresCatalogue = "figures_files";
        File catalogue = new File(figuresCatalogue);

        if (catalogue.isDirectory()) {
            String[] files = Objects.requireNonNull(catalogue.list());
            for (String fileName : files) {
                String localPath = figuresCatalogue + File.separator + fileName;
                System.out.println("Найден файл " + localPath);


                for (Map<String, String> map : readFigures(localPath)) {
                    Figure newFigure = convertXMLToFigure(map);
                    result.add(newFigure);
                }
            }
        }
        return result;

    }
}

package controllers;

import models.Board;
import models.CellsType;
import models.figures.Figure;

public class InsertFigureToBoardController {

    public static void  insert(Board board, Figure figure, long row, long column) {
        for(long i = 0; i < figure.getHeight(); i++) {
            for (long j = 0; j < figure.getWidth(); j++) {
                if (figure.getFigureArray().get((int)i).get((int)j).equals(CellsType.LIVE)) {
                    board.setCell(CellsType.LIVE, row + i, column + j);
                }
            }
        }
    }
}

package controllers;

import models.Board;
import models.CellsType;

public class BorderRules {
    public static boolean needAddLeftBorder(Board board) {
        long height = board.getHeight();
        for (long i = 0; i < height; i++){
            if (board.getCell(i, 0).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }
}
